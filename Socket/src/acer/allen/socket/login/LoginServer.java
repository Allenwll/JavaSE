package acer.allen.socket.login;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 
 * @author acer
 *
 */
public class LoginServer {

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket socket = null;
		ObjectInputStream ois = null;
		DataOutputStream dos = null;
		try {

			// 创建一个Socket服务对象
			server = new ServerSocket(8800);

			// 监听器，一直在监听是否有客户端发来请求  阻塞方法
			System.err.println("等待客户端的连接………………………………");
			//接收客户端的请求 一旦接受到请求 会和客户端建立一个连接，并返回请求连接的socket对象
			socket = server.accept();

			System.out.println("客户端连接成功！");

			// 读取发送的数据
			InputStream is = socket.getInputStream();
			ois = new ObjectInputStream(is);

			// 数据输出流
			dos = new DataOutputStream(socket.getOutputStream());

			User user = (User) ois.readObject();

			// 校验信息
			if (user.getName().equals("bjsxt") && user.getPwd().equals("bjsxt"))
				dos.writeBoolean(true);
			else
				dos.writeBoolean(false);

			System.out.println("接收到客户端发送的数据:\n" + user);

			// 停止读取
			socket.shutdownInput();
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输入
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// 关闭输出流
				if (dos != null)
					dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// 关闭套接字
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// 关闭服务器端
				if (server != null)
					server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
