package easy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器
 * 
 * @author acer
 *
 */
public class TCPServer {
	/**
	 * 入口
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// 创建一个Socket服务器，监听5566端口
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(5566);

		System.err.println("---------------等待连接-------------------");
		int i = 0;

		// 利用死循环不停的监听端口
		while (true) {

			// 利用Socket服务器的accept()方法获取客户端Socket对象。
			Socket s = ss.accept();
			
			i++;
			System.out.println("第" + i + "个客户端成功连接！");

			// 获取客户端Socket对象的输入流，并在外边加一层DataInputStream管道，目的是方便读取数据
			DataInputStream dis = new DataInputStream(s.getInputStream());

			// 读出流中的数据，DataInputStream对象的readUTF()方法可以读出流中的数据，而且支持中文
			System.out.println(dis.readUTF());

			dis.close(); // 关闭管道连接

			s.close(); // 关闭Socket连接
		}
	}

}
