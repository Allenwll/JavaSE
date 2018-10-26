package acer.allen.socket.login;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * 
 * @author acer
 *
 */
public class LoginClient {

	/**
	 * 程序入口
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {

		/*
		 * 创建socket连接对象 InetAddress address =
		 * InetAddress.getByName("192.168.7.109"); Socket socket = new
		 * Socket(address, 2568);
		 */
		Socket socket = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		DataInputStream dis = null;
		Scanner scan = null;
		try {
			// 创建socket连接对象
			socket = new Socket("localhost", 8800);

			// 创建对象输出流
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);

			System.out.println("请输入用户名:");

			scan = new Scanner(System.in);
			String name = scan.next();

			System.out.println("请输入密码:");
			String pwd = scan.next();

			// 发送数据
			oos.writeObject(new User(name, pwd));

			// 接收服务器端的反馈信息，并打印
			dis = new DataInputStream(socket.getInputStream());

			// 得到返回的布尔值
			boolean result = dis.readBoolean();

			// 三目判断
			String str = (result) ? "登陆成功" : "登录失败，重新来过.";

			// 打印结果
			System.out.println("服务器端反馈信息为:" + str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 停止输出
				socket.shutdownOutput();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.shutdownInput();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				// 关闭输出流
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// 关闭输入流
			if (dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			try {
				// 关闭socket
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
