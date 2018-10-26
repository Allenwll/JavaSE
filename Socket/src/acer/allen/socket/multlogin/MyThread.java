package acer.allen.socket.multlogin;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class MyThread extends Thread {

	// Socket客户端实例
	Socket socket = null;

	// 构造方法
	public MyThread(Socket socket) {

		this.socket = socket;

		// 打印客户端IP地址
		System.out.println("IP地址:" + socket.getLocalAddress());
	}

	@Override
	public void run() {

		// 初始化对象流
		ObjectInputStream ois = null;

		// 初始化数据输出流
		DataOutputStream dos = null;

		// 初始化User类
		User user;

		// 输入流
		InputStream is = null;
		try {
			// 实例化输入流
			is = socket.getInputStream();

			// 实例化对象输入流
			ois = new ObjectInputStream(is);

			// 实例化数据输出流
			dos = new DataOutputStream(socket.getOutputStream());

			// 对象反序列化
			user = (User) ois.readObject();

			// 校验信息
			if (user.getName().equals("bjsxt") && user.getPwd().equals("bjsxt"))
				dos.writeBoolean(true);
			else
				dos.writeBoolean(false);
				

			// 打印客户端数据
			System.out.println("接收到客户端发送的数据:" + user);

			// 停止读取
			socket.shutdownInput();

			// 停止写出
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
		}

	}
}
