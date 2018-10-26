package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * 客户类
 * 
 * 1)客户向咨询人员咨询。
 * 
 * 2)咨询人员给出回答。
 * 
 * 3)客户和咨询人员可以一直沟通，直到客户发送bye给咨询人员。
 * 
 * @author acer
 *
 */
public class Client {

	/**
	 * 程序的入口
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 快递员
		DatagramSocket ds = new DatagramSocket(8888);
		// 发送线程
		new SendClient(ds).start();

		while (true) {
			// 读取
			byte[] buff = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buff, buff.length);
			ds.receive(dp);
			String s = new String(dp.getData(), 0, dp.getLength());
			System.out.println("服务器说:" + s);
			if (s.equals("bye")){
				System.err.println("UDP：Client-Receive Over");
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
		// 读取
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {
		String str = null;
		byte[] temp = null;

		try {
			System.out.println("请输入你要说的话：");
			while (true) {
				str = br.readLine();
				temp = str.getBytes();
				// 信件
				DatagramPacket dp = new DatagramPacket(temp, temp.length, InetAddress.getByName("LocalHost"), 8080);
				// 发送
				ds.send(dp);
				if (str.equals("bye")){
					System.err.println("UDP：Client-Send Over");
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
