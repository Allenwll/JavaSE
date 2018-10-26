package acer.allen.socket.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 聊天客户端
 * 
 * @author acer
 *
 */
public class ChatClient {
	/**
	 * 入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 创建套接字对象
		Socket socket = null;

		// 读对象
		BufferedReader br = null;

		try {
			// 指定端口和主机域名
			socket = new Socket("LocalHost", 8080);

			// 开启线程
			new ClientThread(socket).start();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// main线程负责接收服务器发来的信息
			while (true) {
				System.out.println("服务器说:" + br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 关闭流对象
				br.close();
				// 关闭套接字
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class ClientThread extends Thread {

	Socket socket = null;
	BufferedReader br;
	BufferedWriter bw;

	public ClientThread(Socket socket) throws IOException {
		this.socket = socket;
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {
		System.out.println("请输入数据:");

		try {
			while (true) {
				String str = br.readLine();
				bw.write(str + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
