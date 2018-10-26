package acer.allen.datagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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
public class UdpClient {
	/**
	 * 入口
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 创建一个发送数据的对象,相当于邮递员
		DatagramSocket ds = new DatagramSocket();

		// 发送内容
		byte[] buf = "逆风如解意，容易莫摧残".getBytes();

		// 创建数据包，相当于信件
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8080);

		// 发送数据
		ds.send(dp);

		// 定义数组保存
		buf = new byte[1024];

		// 接收服务器端发送过来的数据
		DatagramPacket dpReceive = new DatagramPacket(buf, buf.length);

		// 接收
		ds.receive(dpReceive);

		// 拆包
		String str = new String(dpReceive.getData(), 0, dpReceive.getLength());

		// 打印
		System.out.println("服务器端反馈的信息:" + str);

		// 关闭
		ds.close();
	}
}
