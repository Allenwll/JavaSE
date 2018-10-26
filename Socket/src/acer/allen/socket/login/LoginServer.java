package acer.allen.socket.login;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

		ServerSocket server = null;
		Socket socket = null;
		ObjectInputStream ois = null;
		DataOutputStream dos = null;
		try {

			// ����һ��Socket�������
			server = new ServerSocket(8800);

			// ��������һֱ�ڼ����Ƿ��пͻ��˷�������  ��������
			System.err.println("�ȴ��ͻ��˵����ӡ�����������������������");
			//���տͻ��˵����� һ�����ܵ����� ��Ϳͻ��˽���һ�����ӣ��������������ӵ�socket����
			socket = server.accept();

			System.out.println("�ͻ������ӳɹ���");

			// ��ȡ���͵�����
			InputStream is = socket.getInputStream();
			ois = new ObjectInputStream(is);

			// ���������
			dos = new DataOutputStream(socket.getOutputStream());

			User user = (User) ois.readObject();

			// У����Ϣ
			if (user.getName().equals("bjsxt") && user.getPwd().equals("bjsxt"))
				dos.writeBoolean(true);
			else
				dos.writeBoolean(false);

			System.out.println("���յ��ͻ��˷��͵�����:\n" + user);

			// ֹͣ��ȡ
			socket.shutdownInput();
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر�����
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// �ر������
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// �ر��׽���
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// �رշ�������
				if (server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
