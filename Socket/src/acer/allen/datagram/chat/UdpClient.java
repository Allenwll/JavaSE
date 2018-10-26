package acer.allen.datagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP �µ�socket �ͻ��� ����������
 * 
 * Ч�ʸ� ���׶���
 * 
 * ���ݱ�
 * 
 * @author acer
 *
 */
public class UdpClient {
	/**
	 * ���
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ����һ���������ݵĶ���,�൱���ʵ�Ա
		DatagramSocket ds = new DatagramSocket();

		// ��������
		byte[] buf = "�������⣬����Ī�ݲ�".getBytes();

		// �������ݰ����൱���ż�
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8080);

		// ��������
		ds.send(dp);

		// �������鱣��
		buf = new byte[1024];

		// ���շ������˷��͹���������
		DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);

		// ����
		ds.receive(dpReceive);

		// ���
		String str = new String(dpReceive.getData(), 0, dpReceive.getLength());

		// ��ӡ
		System.out.println("�������˷�������Ϣ:" + str);

		// �ر�
		ds.close();
	}
}
