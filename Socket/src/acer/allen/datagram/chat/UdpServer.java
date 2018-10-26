package acer.allen.datagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �����
 * 
 * @author acer
 *
 */
public class UdpServer {

	public static void main(String[] args) throws IOException {
		// �����ʵ�Ա����
		DatagramSocket ds = new DatagramSocket(8080);
		// ��������
		byte[] buf = new byte[1024];
		// �����ż�
		DatagramPacket dp = new DatagramPacket(buf, buf.length);

		System.err.println("���ڲ���������ݣ����Ժ�...............\n");

		// ���� ����
		ds.receive(dp);

		// �õ�����
		System.out.println("����:" + dp.getLength());

		// �õ���ַ
		System.out.println("��ַ:" + dp.getAddress());

		// �õ��ͻ���Ĭ�϶˿ں�
		System.out.println("�˿ں�:" + dp.getPort());

		// �������ַ���
		String str = new String(dp.getData(), 0, dp.getLength());

		System.out.print("���յ���������:" + str);

		// ��������
		buf = "������ʱҹߵ��".getBytes();

		// ���
		DatagramPacket dpSend = new DatagramPacket(buf, buf.length, dp.getAddress(), dp.getPort());

		// ����
		ds.send(dpSend);

		// �ر�
		ds.close();

	}

}
