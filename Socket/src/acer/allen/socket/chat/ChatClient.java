package acer.allen.socket.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * ����ͻ���
 * 
 * @author acer
 *
 */
public class ChatClient {
	/**
	 * ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// �����׽��ֶ���
		Socket socket = null;

		// ������
		BufferedReader br = null;

		try {
			// ָ���˿ں���������
			socket = new Socket("LocalHost", 8080);

			// �����߳�
			new ClientThread(socket).start();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// main�̸߳�����շ�������������Ϣ
			while (true) {
				System.out.println("������˵:" + br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// �ر�������
				br.close();
				// �ر��׽���
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class ClientThread extends Thread {

	Socket socket = null;
	BufferedReader br;
	BufferedWriter bw;

	public ClientThread(Socket socket) throws IOException {
		this.socket = socket;
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {
		System.out.println("����������:");

		try {
			while (true) {
				String str = br.readLine();
				bw.write(str + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
