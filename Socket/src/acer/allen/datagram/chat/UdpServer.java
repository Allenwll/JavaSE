package acer.allen.datagram.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 * 
 * @author acer
 *
 */
public class UdpServer {

	public static void main(String[] args) throws IOException {
		// 创建邮递员对象
		DatagramSocket ds = new DatagramSocket(8080);
		// 放入容量
		byte[] buf = new byte[1024];
		// 数据信件
		DatagramPacket dp = new DatagramPacket(buf, buf.length);

		System.err.println("正在拆包处理数据，请稍候...............\n");

		// 接收 阻塞
		ds.receive(dp);

		// 得到长度
		System.out.println("长度:" + dp.getLength());

		// 得到地址
		System.out.println("地址:" + dp.getAddress());

		// 得到客户端默认端口号
		System.out.println("端口号:" + dp.getPort());

		// 解析成字符串
		String str = new String(dp.getData(), 0, dp.getLength());

		System.out.print("接收到的数据是:" + str);

		// 返回数据
		buf = "拄杖无时夜叩门".getBytes();

		// 封包
		DatagramPacket dpSend = new DatagramPacket(buf, buf.length, dp.getAddress(), dp.getPort());

		// 发送
		ds.send(dpSend);

		// 关闭
		ds.close();

	}

}
