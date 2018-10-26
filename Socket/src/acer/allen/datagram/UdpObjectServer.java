package acer.allen.datagram;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �����
 * 
 * @author acer
 *
 */
public class UdpObjectServer {

	/**
	 * ��������
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// ����һ�����ն���    �ʵ�Ա
		DatagramSocket ds = new DatagramSocket(8080);
		// ��ӡ��ʾ
		System.err.println("���ڲ���������ݣ����Ժ�...............\n");
		// ��������
		byte[] buf = new byte[1024];
		// ���
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// ����
		ds.receive(dp);
		// �õ�����
		byte[] temp = dp.getData();
		// �ֽ����黺���� ���ֽ�����ת���ɶ���
		ByteArrayInputStream bis = new ByteArrayInputStream(temp);
		// �ö�������װ�ֽ����鵽����
		ObjectInputStream ois = new ObjectInputStream(bis);
		// �������л�
		User user = (User) ois.readObject();
		// ��ӡ����
		System.out.println("�ͻ���:" + user);
		// �رս��ն���
		ds.close();

	}

}