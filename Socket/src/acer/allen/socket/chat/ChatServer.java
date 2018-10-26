package acer.allen.socket.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * ���������
 * 
 * @author acer
 *
 */
public class ChatServer {
	/**
	 * ��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������˶���
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader br = null;
		try {
			// ָ������˶˿�
			server = new ServerSocket(8080);

			System.out.println("\t�������������������������ȴ��ͻ��˵����ӡ�������������������");
			// �����׽���
			socket = server.accept();

			System.out.println("�ͻ������ӳɹ���");
			
			//������ʾ��
			JOptionPane.showMessageDialog(null, "�пͻ������ӵ��˱�����8080�˿�");

			// �����߳�
			new ServerThread(socket).start();

			// ���߳�������ȡ�ͻ��˷�������Ϣ
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String data = br.readLine();
				System.out.println("�ͻ���˵��" + data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class ServerThread extends Thread {

	Socket socket = null;
	BufferedReader br;
	BufferedWriter bw;

	public ServerThread(Socket socket) throws IOException {
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
