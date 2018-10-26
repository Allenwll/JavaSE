package acer.allen.datagram.multlchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

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
public class UdpChatClient {
	/**
	 * ���
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ����һ���������ݵĶ���,�൱���ʵ�Ա
		DatagramSocket ds = new DatagramSocket(8888);
		// ����
		Scanner s = new Scanner(System.in);
		// ���������߳�
		new Thread(new SendThread(s, ds)).start();
		// ���������߳�
		new Thread(new ReceiveThread(ds)).start();
	}
	
}

/**
 * �ͻ��˷����߳�
 * 
 * @author acer
 *
 */
class SendThread implements Runnable {
	// ����������
	Scanner s = null;
	// ���Ͷ���
	DatagramSocket ds = null;

	public SendThread(Scanner s, DatagramSocket ds) {
		this.s = s;
		this.ds = ds;
	}

	@Override
	public void run() {
		System.err.println("����������:  ����bye�˳�\n");
		while (true) {
			// ��������
			String data = s.nextLine();
			// ��������
			byte[] buf = data.getBytes();
			try {
				// �������ݰ����൱���ż�
				DatagramPacket dpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8080);
				// ��������
				ds.send(dpSend);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (data.equals("bye")) {
				System.err.println("UDP��Client Send Over");
				System.exit(0);
				break;
			}
		}
		
	}
}

/**
 * �ͻ��˽����߳�
 * 
 * @author acer
 *
 */
class ReceiveThread implements Runnable {
	// ���ն���
	DatagramSocket ds = null;

	public ReceiveThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			// ���շ������˷��͹���������
			DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
			// ����
			try {
				ds.receive(dpReceive);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ���
			String str = new String(dpReceive.getData(), 0, dpReceive.getLength());
			// ��ӡ
			System.out.println("��������:" + str);
			// �ж�
			if (str.equals("bye")) {
				System.err.println("UDP �� Client Recerve Over");
				System.exit(0);
				break;
			}
		}
		ds.close();
	}

}