package login;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * �ͻ���
 * 
 * @author acer
 *
 */
public class LoginClient {

	public static void main(String[] args) {
		// �ͻ���
		Socket socket;
		// ������
		ObjectOutputStream oos = null;
		// ����������
		DataInputStream dis = null;
		Scanner s = null;
		try {
			// ָ���ͻ������� �Ͷ˿�
			socket = new Socket("127.0.0.1", 8080);
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("�������û���:");
			s = new Scanner(System.in);
			String name = s.nextLine();
			System.out.println("����������:");
			String pwd = s.nextLine();
			oos.writeObject(new User(name, pwd));
			oos.flush();
			dis = new DataInputStream(socket.getInputStream());
			boolean result = dis.readBoolean();

			System.out.println("�����˵:" + (result ? "��½�ɹ�" : "��¼ʧ��"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
