package acer.allen.datagram;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 * 
 * @author acer
 *
 */
public class UdpObjectServer {

	/**
	 * 程序的入口
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 创建一个接收对象    邮递员
		DatagramSocket ds = new DatagramSocket(8080);
		// 打印提示
		System.err.println("正在拆包处理数据，请稍候...............\n");
		// 定义数组
		byte[] buf = new byte[1024];
		// 拆包
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// 接收
		ds.receive(dp);
		// 得到数据
		byte[] temp = dp.getData();
		// 字节数组缓存区 将字节数组转化成对象
		ByteArrayInputStream bis = new ByteArrayInputStream(temp);
		// 用对象流包装字节数组到对象
		ObjectInputStream ois = new ObjectInputStream(bis);
		// 对象反序列化
		User user = (User) ois.readObject();
		// 打印数据
		System.out.println("客户端:" + user);
		// 关闭接收对象
		ds.close();

	}

}