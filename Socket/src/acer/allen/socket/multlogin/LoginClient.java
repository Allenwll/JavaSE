package acer.allen.socket.multlogin;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * �ͻ���
 * 
 * @author acer
 *
 */
public class LoginClient {

	/**
	 * �������
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		/*
		 * ����socket���Ӷ��� InetAddress address =
		 * InetAddress.getByName("192.168.7.109"); Socket socket = new
		 * Socket(address, 2568);
		 */

		// ����socket���Ӷ���
		Socket socket = null;

		// ���������
		OutputStream os = null;

		// �������������
		ObjectOutputStream oos = null;

		// ��������������
		DataInputStream dis = null;

		// ������׼�������
		Scanner scan = null;

		try {

			// ʵ�������Ӷ���
			socket = new Socket("localhost", 8800);

			// ʵ���������
			os = socket.getOutputStream();

			// ʵ����������
			oos = new ObjectOutputStream(os);

			// ��ӡ��ʾ
			System.out.println("�������û���:");

			// ʵ����
			scan = new Scanner(System.in);

			// ��������
			String name = scan.next();

			// ��ӡ��ʾ
			System.out.println("����������:");

			// ��������
			String pwd = scan.next();

			// ��������
			oos.writeObject(new User(name, pwd));

			// ���շ������˵ķ�����Ϣ������ӡ
			dis = new DataInputStream(socket.getInputStream());

			// �õ����صĲ���ֵ
			boolean result = dis.readBoolean();

			// ��Ŀ�ж�
			String str = (result) ? "��½�ɹ�" : "��¼ʧ�ܣ���������.";

			// ��ӡ���
			System.out.println("�������˷�����ϢΪ:" + str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// ֹͣ���
				socket.shutdownOutput();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// ֹͣ����
				socket.shutdownInput();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				// �ر������
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {

				// �ر�������
				if (dis != null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				// �ر�socket
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
