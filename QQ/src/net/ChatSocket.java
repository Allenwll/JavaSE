package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * 监听Socket类
 * 
 * @author acer
 *
 */
public class ChatSocket extends Thread {

	// socket对象
	Socket socket;

	// 写出
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
	 * 写出方法
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
		
		// 写出
		// socket.getOutputStream().write(out.getBytes("UTF-8"));
		// socket.getOutputStream().flush();
		/*
		 * // 实例化写出流 BufferedWriter bw = new BufferedWriter(new
		 * BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
		 * bw.write(out);
		 */

	}

	public void run() {

		try {

			// 字节缓冲
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 字符串
			String line = null;
			while ((line = br.readLine()) != null) {
				// 发送
				ChatManager.getChatManager().publish(this, line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	};
}
