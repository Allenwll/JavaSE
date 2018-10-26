package QQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * �ͻ���
 * 
 * @author acer
 *
 */
public class Client {
	public static void main(String[] args) throws IOException {

		// ���췽��
		chat();
	}

	/**
	 * ����
	 * 
	 * @throws IOException
	 */
	static void chat() throws IOException {
		Socket socket = null;
		BufferedReader br = null;

		try {
			socket = new Socket("localhost", 8080);
			new SendThread(socket).start();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String line = br.readLine();
				System.out.println("������˵:" + line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}
}

/**
 * �����߳�
 * 
 * @author acer
 *
 */
class SendThread extends Thread {
	Socket socket;
	BufferedReader br = null;
	BufferedWriter bw = null;

	public SendThread(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	@Override
	public void run() {
		String line = null;
		System.out.println("����������Ҫ˵�Ļ���");
		try {

			while (true) {
				line = br.readLine();
				bw.write(line);
				bw.newLine();
				bw.flush();
				if (line == null)
					break;

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}