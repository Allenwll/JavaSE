package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �ͻ���
 * 
 * @author acer
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(8080);
		System.err.println("-------�����-----------------");
		new SendServer(ds).start();
		while (true) {
			byte[] temp = new byte[1024];
			DatagramPacket dp = new DatagramPacket(temp, temp.length);
			ds.receive(dp);
			String data = new String(dp.getData(), 0, dp.getLength());
			System.out.println("�ͻ���˵:" + data);
			if (data.equals("bye")) {
				System.err.println("UDP��Server-Receive Over");
				System.exit(0);
				break;
			}
		}
		ds.close();

	}
}

class SendServer extends Thread {
	DatagramSocket ds = null;
	BufferedReader br = null;

	public SendServer(DatagramSocket ds) {
		this.ds = ds;
		// ��ȡ
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {
		String str = null;
		byte[] temp = null;

		try {
			System.out.println("��������Ҫ˵�Ļ���");
			while (true) {
				str = br.readLine();
				temp = str.getBytes();
				// �ż�
				DatagramPacket dp = new DatagramPacket(temp, temp.length, InetAddress.getByName("LocalHost"), 8888);
				// ����
				ds.send(dp);
				if (str.equals("bye")) {
					System.err.println("UDP��Server-Send Over");
					System.exit(0);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ds.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
