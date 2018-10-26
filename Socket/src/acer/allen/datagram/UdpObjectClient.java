package acer.allen.datagram;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class UdpObjectClient {
	/**
	 * ���
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ����һ���������ݵĶ���,�൱���ʵ�Ա �˿ں��Ƿ��Ͷ˿ںţ�����ʹ��ϵͳ�ṩ�ģ��Լ���ָ���˿ں�
		DatagramSocket ds = new DatagramSocket(8888);
		// ��Ҫд�������
		User user = new User("Mars", "123456");
		// �Դ����������ֽ����� �����������д������ݣ����ֽ��������ʽ����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// ʹ�ö��������а�װ������д�����
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		// д�����󣬵�������
		oos.writeObject(user);
		byte[] buf = baos.toByteArray();
		// ��������
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8080);
		// ��������
		ds.send(dp);
		// �رշ��Ͷ���
		ds.close();

	}

}