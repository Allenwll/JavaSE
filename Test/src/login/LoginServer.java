package login;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������
 * 
 * @author acer
 *
 */
public class LoginServer {

	public static void main(String[] args) {
		// �������˶���
		ServerSocket server = null;
		// �ͻ��˶���
		Socket socket = null;

		try {
			// ָ���˿�
			server = new ServerSocket(8080);
			System.err.println("�ȴ��ͻ������ӡ�������������������������������������������");
			while (true) {
				// ������Ӧ���ɶ���
				socket = server.accept();
				System.out.println("�ͻ������ӳɹ���");
				
				new MyThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

class MyThread extends Thread {
	Socket socket;
	// ������
	ObjectInputStream ois = null;
	DataOutputStream dos = null;
	User user;

	public MyThread(Socket socket) {
		this.socket = socket;

	}

	public void run() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			user = (User) ois.readObject();
			if (user.getName().equals("bjsxt") && user.getPwd().equals("bjsxt"))
				try {
					dos.writeBoolean(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				dos.writeBoolean(false);
			System.out.println("�ͻ���:" + user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}