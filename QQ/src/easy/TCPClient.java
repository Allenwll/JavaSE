package easy;

import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws Exception {

		// 创建一个Socket对象，连接IP地址为127.0.0.1的服务器的5566端口
		Socket s = new Socket("127.0.0.1", 5566);

		// 获取Socket对象的输出流，并且在外边包一层DataOutputStream管道，方便输出数据
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		// DataOutputStream对象的writeUTF()方法可以输出数据，并且支持中文
		dos.writeUTF("客户端消息");

		// 确保所有数据都已经输出
		dos.flush();

		// 关闭输出流
		dos.close();

		// 关闭Socket连接
		s.close();
	}
}
