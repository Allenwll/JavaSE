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
 * 1)�ͻ�����ѯ��Ա��ѯ��
 * 
 * 2)��ѯ��Ա�����ش�
 * 
 * 3)�ͻ�����ѯ��Ա����һֱ��ͨ��ֱ���ͻ�����bye����ѯ��Ա��
 * 
 * @author acer
 *
 */
public class Client {

	/**
	 * ��������
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ���Ա
		DatagramSocket ds = new DatagramSocket(8888);
		// �����߳�
		new SendClient(ds).start();

		while (true) {
			// ��ȡ
			byte[] buff = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buff, buff.length);
			ds.receive(dp);
			String s = new String(dp.getData(), 0, dp.getLength());
			System.out.println("������˵:" + s);
			if (s.equals("bye")){
				System.err.println("UDP��Client-Receive Over");
				System.exit(0);
				break;
			}
		}
		ds.close();
	}
}

class SendClient extends Thread {
	DatagramSocket ds = null;
	BufferedReader br = null;

	public SendClient(DatagramSocket ds) {
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
				DatagramPacket dp = new DatagramPacket(temp, temp.length, InetAddress.getByName("LocalHost"), 8080);
				// ����
				ds.send(dp);
				if (str.equals("bye")){
					System.err.println("UDP��Client-Send Over");
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
