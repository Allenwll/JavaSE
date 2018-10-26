package acer.allen.socket.multlogin;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class MyThread extends Thread {

	// Socket�ͻ���ʵ��
	Socket socket = null;

	// ���췽��
	public MyThread(Socket socket) {

		this.socket = socket;

		// ��ӡ�ͻ���IP��ַ
		System.out.println("IP��ַ:" + socket.getLocalAddress());
	}

	@Override
	public void run() {

		// ��ʼ��������
		ObjectInputStream ois = null;

		// ��ʼ�����������
		DataOutputStream dos = null;

		// ��ʼ��User��
		User user;

		// ������
		InputStream is = null;
		try {
			// ʵ����������
			is = socket.getInputStream();

			// ʵ��������������
			ois = new ObjectInputStream(is);

			// ʵ�������������
			dos = new DataOutputStream(socket.getOutputStream());

			// �������л�
			user = (User) ois.readObject();

			// У����Ϣ
			if (user.getName().equals("bjsxt") && user.getPwd().equals("bjsxt"))
				dos.writeBoolean(true);
			else
				dos.writeBoolean(false);
				

			// ��ӡ�ͻ�������
			System.out.println("���յ��ͻ��˷��͵�����:" + user);

			// ֹͣ��ȡ
			socket.shutdownInput();

			// ֹͣд��
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
		}

	}
}
