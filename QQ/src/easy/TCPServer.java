package easy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������
 * 
 * @author acer
 *
 */
public class TCPServer {
	/**
	 * ���
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// ����һ��Socket������������5566�˿�
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(5566);

		System.err.println("---------------�ȴ�����-------------------");
		int i = 0;

		// ������ѭ����ͣ�ļ����˿�
		while (true) {

			// ����Socket��������accept()������ȡ�ͻ���Socket����
			Socket s = ss.accept();
			
			i++;
			System.out.println("��" + i + "���ͻ��˳ɹ����ӣ�");

			// ��ȡ�ͻ���Socket�������������������߼�һ��DataInputStream�ܵ���Ŀ���Ƿ����ȡ����
			DataInputStream dis = new DataInputStream(s.getInputStream());

			// �������е����ݣ�DataInputStream�����readUTF()�������Զ������е����ݣ�����֧������
			System.out.println(dis.readUTF());

			dis.close(); // �رչܵ�����

			s.close(); // �ر�Socket����
		}
	}

}
