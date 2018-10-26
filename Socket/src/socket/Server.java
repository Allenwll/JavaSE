package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 
 * @author acer
 *
 */
/**
 * @author acer
 *
 */
public class Server {

	/**
	 * 程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 服务端
		ServerSocket server = null;

		// 客户端
		Socket socket = null;

		// 缓冲流
		BufferedReader line = null;

		try {
			// 指定端口号
			server = new ServerSocket(8080);

			// 提示
			System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^等待客户端连接^^^^^^^^^^^^^^^^^^^^^^^^^^");

			// 接收客户端请求
			socket = server.accept();

			// 提示
			System.out.println("客户端连接成功！");

			// 开启发送线程
			new ServerThread(socket).start();

			// 读取
			line = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {

				String data = line.readLine();
				// bye 退出
				if (data.equals("bye")) {

					// 提示
					System.err.println("Client Over this meeting .");

					// 退出
					System.exit(0);
				}

				// 提示
				System.out.println("客户端说:" + data);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				// 关闭流
				line.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// 关闭套接字
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// 关闭服务器端
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 发送线程
 * 
 * @author acer
 *
 */
class ServerThread extends Thread {

	// 客户端
	Socket socket;

	// 读
	BufferedReader br = null;

	// 写
	BufferedWriter bw = null;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;

		// 控制台数据读入
		br = new BufferedReader(new InputStreamReader(System.in));

		// 写出
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	}

	@Override
	public void run() {
		try {
			// 提示
			System.out.println("请输入您要说的话:");
			while (true) {

				// 按行读取
				String data = br.readLine();

				// 写出
				bw.write(data + "\n");

				// 刷新
				bw.flush();

				// bye 退出
				if (data.equals("bye")) {

					// 提示
					System.err.println("Server Over this meeting .");

					// 退出
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
