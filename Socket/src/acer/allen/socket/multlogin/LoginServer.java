package acer.allen.socket.multlogin;

import java.io.IOException;
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
		try {
			// 创建一个Socket服务对象
			server = new ServerSocket(8800);
			
			//提示信息
			System.err.println("等待客户端的连接………………………………");
			while (true) {
				
				// 接收客户端的请求 一旦接受到请求 会和客户端建立一个连接，并返回请求连接的socket对象
				Socket socket = server.accept();
				
				//提示信息
				System.out.println("\t客户端连接成功！");
				
				// 开启一个线程
				new MyThread(socket).start();
			}
		} catch (Exception e) {
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
