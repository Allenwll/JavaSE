package acer.allen.socket.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 聊天服务器
 * 
 * @author acer
 *
 */
public class ChatServer {
	/**
	 * 程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建服务端对象
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader br = null;
		try {
			// 指定服务端端口
			server = new ServerSocket(8080);

			System.out.println("\t………………………………等待客户端的连接…………………………");
			// 生成套接字
			socket = server.accept();

			System.out.println("客户端连接成功！");
			
			//弹出提示框
			JOptionPane.showMessageDialog(null, "有客户端链接到了本机的8080端口");

			// 开启线程
			new ServerThread(socket).start();

			// 主线程用来读取客户端发来的信息
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String data = br.readLine();
				System.out.println("客户端说：" + data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class ServerThread extends Thread {

	Socket socket = null;
	BufferedReader br;
	BufferedWriter bw;

	public ServerThread(Socket socket) throws IOException {
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
