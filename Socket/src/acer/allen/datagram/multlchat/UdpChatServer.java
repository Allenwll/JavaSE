package acer.allen.datagram.multlchat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 服务端
 * 
 * @author acer
 *
 */
public class UdpChatServer {

	public static void main(String[] args) throws IOException {
		// 创建接收 邮递员对象
		DatagramSocket ds = new DatagramSocket(8080);
		// 输入流对象
		Scanner s = new Scanner(System.in);
		// 提示
		System.err.println("......................正在拆包处理数据，请稍候...............\n");
		// 开启接收线程
		new Thread(new ReceiveServerThread(ds)).start();
		// 开启发送线程
		new Thread(new SendServerThread(ds, s)).start();

	}

}

/**
 * 服务器接收端
 * 
 * @author acer
 *
 */
class ReceiveServerThread implements Runnable {
	// 接收对象
	DatagramSocket ds = null;

	public ReceiveServerThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {

		while (true) {
			// 数组初始化
			byte[] buf = new byte[1024];
			// 将要拆包的对象
			DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);
			// 接收
			try {
				ds.receive(dpReceive);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 分解 拆包
			String str = new String(dpReceive.getData(), 0, dpReceive.getLength());
			// 打印客户端发送过来的信息
			System.out.println("客户端:" + str);
			// 客户端输入bye 退出
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
 * 服务器发送线程
 * 
 * @author acer
 *
 */
class SendServerThread implements Runnable {
	// 发送对象
	DatagramSocket ds = null;
	// 输入流对象
	Scanner s = null;

	public SendServerThread(DatagramSocket ds, Scanner s) {
		this.ds = ds;
		this.s = s;
		System.err.println("输入bye结束会话");
	}

	@Override
	public void run() {
		while (true) {
			// 得到输入数据
			String data = s.nextLine();
			// 转换成数组
			byte[] buff = data.getBytes();
			try {
				// 封包
				DatagramPacket dpSend = new DatagramPacket(buff, buff.length, InetAddress.getByName("LocalHost"), 8888);
				// 发送
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