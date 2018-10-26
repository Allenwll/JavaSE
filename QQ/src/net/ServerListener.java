package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务监听类
 * 
 * @author acer
 *
 */
public class ServerListener extends Thread {
	// 1-65535
	@Override
	public void run() {
		try {
			// 指定服务器对象端口
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(8000);

			// 提示
			System.err.println("-----------------等待连接-------------------------");
			while (true) {
				
				// 接收请求
				Socket socket = server.accept();

				// 提示
				System.out.println("连接成功！");
				//JOsptionPane.showMessageDialog(null, "有客户端链接到了本机的8000端口");
				
				
				// 将socket传递给新的线程
				ChatSocket cs = new ChatSocket(socket);
				
				//开启线程
				cs.start();

				//单例模式添加
				ChatManager.getChatManager().add(cs);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
