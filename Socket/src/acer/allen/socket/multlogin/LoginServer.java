package acer.allen.socket.multlogin;

import java.io.IOException;
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
		try {
			// ����һ��Socket�������
			server = new ServerSocket(8800);
			
			//��ʾ��Ϣ
			System.err.println("�ȴ��ͻ��˵����ӡ�����������������������");
			while (true) {
				
				// ���տͻ��˵����� һ�����ܵ����� ��Ϳͻ��˽���һ�����ӣ��������������ӵ�socket����
				Socket socket = server.accept();
				
				//��ʾ��Ϣ
				System.out.println("\t�ͻ������ӳɹ���");
				
				// ����һ���߳�
				new MyThread(socket).start();
			}
		} catch (Exception e) {
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
