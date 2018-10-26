package acer.allen.datagram;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
public class UdpObjectClient {
	/**
	 * 入口
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 创建一个发送数据的对象,相当于邮递员 端口号是发送端口号，可以使用系统提供的，自己不指定端口号
		DatagramSocket ds = new DatagramSocket(8888);
		// 将要写入的数据
		User user = new User("Mars", "123456");
		// 自带缓冲区的字节数组 用来缓存接收写入的数据，以字节数组的形式保存
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 使用对象流进行包装，方便写入对象
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		// 写出对象，到缓冲区
		oos.writeObject(user);
		byte[] buf = baos.toByteArray();
		// 发送内容
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), 8080);
		// 发送数据
		ds.send(dp);
		// 关闭发送对象
		ds.close();

	}

}