package acer.allen.datagram.multlchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP 下的socket 客户端 面向无连接
 * 
 * 效率高 容易丢包
 * 
 * 数据报
 * 
 * @author acer
 *
 */
public class UdpChatClient {
	/**
	 * 入口
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 创建一个发送数据的对象,相当于邮递员
		DatagramSocket ds = new DatagramSocket(8888);
		// 输入
		Scanner s = new Scanner(System.in);
		// 开启发送线程
		new Thread(new SendThread(s, ds)).start();
		// 开启接收线程
		new Thread(new ReceiveThread(ds)).start();
	}
	
}

/**
 * 客户端发送线程
 * 
 * @author acer
 *
 */
class SendThread implements Runnable {
	// 输入流对象
	Scanner s = null;
	// 发送对象
	DatagramSocket ds = null;

	public SendThread(Scanner s, DatagramSocket ds) {
		this.s = s;
		this.ds = ds;
	}

	@Override
	public void run() {
		System.err.println("请输入数据:  输入bye退出\n");
		while (true) {
			// 输入内容
			String data = s.nextLine();
			// 发送内容
			byte[] buf = data.getBytes();
			try {
				// 创建数据包，相当于信件
				DatagramPacket dpSend = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8080);
				// 发送数据
				ds.send(dpSend);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (data.equals("bye")) {
				System.err.println("UDP：Client Send Over");
				System.exit(0);
				break;
			}
		}
		
	}
}

/**
 * 客户端接收线程
 * 
 * @author acer
 *
 */
class ReceiveThread implements Runnable {
	// 接收对象
	DatagramSocket ds = null;

	public ReceiveThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		while (true) {
			byte[] buf = new byte[1024];
			// 接收服务器端发送过来的数据
			DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
			// 接收
			try {
				ds.receive(dpReceive);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 拆包
			String str = new String(dpReceive.getData(), 0, dpReceive.getLength());
			// 打印
			System.out.println("服务器端:" + str);
			// 判断
			if (str.equals("bye")) {
				System.err.println("UDP ： Client Recerve Over");
				System.exit(0);
				break;
			}
		}
		ds.close();
	}

}