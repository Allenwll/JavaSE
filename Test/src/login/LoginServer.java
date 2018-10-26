package login;

import java.io.DataOutputStream;
import java.io.IOException;
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
		// 服务器端对象
		ServerSocket server = null;
		// 客户端对象
		Socket socket = null;

		try {
			// 指定端口
			server = new ServerSocket(8080);
			System.err.println("等待客户端连接…………………………………………………………");
			while (true) {
				// 请求响应生成对象
				socket = server.accept();
				System.out.println("客户端连接成功！");
				
				new MyThread(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

class MyThread extends Thread {
	Socket socket;
	// 读数据
	ObjectInputStream ois = null;
	DataOutputStream dos = null;
	User user;

	public MyThread(Socket socket) {
		this.socket = socket;

	}

	public void run() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			user = (User) ois.readObject();
			if (user.getName().equals("bjsxt") && user.getPwd().equals("bjsxt"))
				try {
					dos.writeBoolean(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			else
				dos.writeBoolean(false);
			System.out.println("客户端:" + user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}