package easy;

import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws Exception {

		// ����һ��Socket��������IP��ַΪ127.0.0.1�ķ�������5566�˿�
		Socket s = new Socket("127.0.0.1", 5566);

		// ��ȡSocket��������������������߰�һ��DataOutputStream�ܵ��������������
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		// DataOutputStream�����writeUTF()��������������ݣ�����֧������
		dos.writeUTF("�ͻ�����Ϣ");

		// ȷ���������ݶ��Ѿ����
		dos.flush();

		// �ر������
		dos.close();

		// �ر�Socket����
		s.close();
	}
}
