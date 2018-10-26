package acer.allen.datagram.multlchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * �����
 * 
 * @author acer
 *
 */
public class UdpChatServer {

	public static void main(String[] args) throws IOException {
		// �������� �ʵ�Ա����
		DatagramSocket ds = new DatagramSocket(8080);
		// ����������
		Scanner s = new Scanner(System.in);
		// ��ʾ
		System.err.println("......................���ڲ���������ݣ����Ժ�...............\n");
		// ���������߳�
		new Thread(new ReceiveServerThread(ds)).start();
		// ���������߳�
		new Thread(new SendServerThread(ds, s)).start();

	}

}

/**
 * ���������ն�
 * 
 * @author acer
 *
 */
class ReceiveServerThread implements Runnable {
	// ���ն���
	DatagramSocket ds = null;

	public ReceiveServerThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {

		while (true) {
			// �����ʼ��
			byte[] buf = new byte[1024];
			// ��Ҫ����Ķ���
			DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
			// ����
			try {
				ds.receive(dpReceive);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// �ֽ� ���
			String str = new String(dpReceive.getData(), 0, dpReceive.getLength());
			// ��ӡ�ͻ��˷��͹�������Ϣ
			System.out.println("�ͻ���:" + str);
			// �ͻ�������bye �˳�
			if (str.equals("bye")) {
				System.err.println("UDP: Server Receiver Over");
				System.exit(0);
				break;
			}

		}
		ds.close();
	}

}

/**
 * �����������߳�
 * 
 * @author acer
 *
 */
class SendServerThread implements Runnable {
	// ���Ͷ���
	DatagramSocket ds = null;
	// ����������
	Scanner s = null;

	public SendServerThread(DatagramSocket ds, Scanner s) {
		this.ds = ds;
		this.s = s;
		System.err.println("����bye�����Ự");
	}

	@Override
	public void run() {
		while (true) {
			// �õ���������
			String data = s.nextLine();
			// ת��������
			byte[] buff = data.getBytes();
			try {
				// ���
				DatagramPacket dpSend = new DatagramPacket(buff, buff.length, InetAddress.getByName("LocalHost"), 8888);
				// ����
				ds.send(dpSend);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (data.equals("bye")) {
				System.err.println("UDP: Server Send over");
				System.exit(0);
				break;
			}
		}

	}
}