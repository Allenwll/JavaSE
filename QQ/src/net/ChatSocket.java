package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * ����Socket��
 * 
 * @author acer
 *
 */
public class ChatSocket extends Thread {

	// socket����
	Socket socket;

	// д��
	BufferedWriter bw = null;

	public ChatSocket(Socket socket) {
		this.socket = socket;
		try {
			bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * д������
	 * 
	 * @param out
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void out(String out) throws UnsupportedEncodingException, IOException {

		//System.out.println("out-----"+out);
		bw.write(out);
		bw.newLine();
		bw.flush();
		
		// д��
		// socket.getOutputStream().write(out.getBytes("UTF-8"));
		// socket.getOutputStream().flush();
		/*
		 * // ʵ����д���� BufferedWriter bw = new BufferedWriter(new
		 * BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		 * bw.write(out);
		 */

	}

	public void run() {

		try {

			// �ֽڻ���
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// �ַ���
			String line = null;
			while ((line = br.readLine()) != null) {
				// ����
				ChatManager.getChatManager().publish(this, line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	};
}
