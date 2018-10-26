package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端
 * 
 * @author acer
 *
 */
public class Client {
	/**
	 * 程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 客户端
		Socket socket = null;

		// 读取缓冲流
		BufferedReader br = null;

		try {

			// 指定服务端IP地址和端口号
			socket = new Socket("LocalHost", 8080);

			// 开启发送数据线程
			new ClientThread(socket).start();

			// 实例化缓冲流
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 永真循环
			while (true) {
					
				// bye 退出
				if (br.readLine().equals("bye")) {

					// 提示
					System.err.println("Server Over this meeting .");

					// 退出
					System.exit(0);
				}
				
				System.out.println("服务器端说：" + br.readLine());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流对象
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// 关闭socket套接字
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 发送数据线程
 * 
 * @author acer
 *
 */
class ClientThread extends Thread {

	// 实例化套接字对象
	Socket socket;

	// 字符缓冲流
	BufferedReader br;

	// 打印流
	PrintWriter out;

	public ClientThread(Socket socket) throws IOException {
		this.socket = socket;

		// 实例化，自动刷新
		out = new PrintWriter(socket.getOutputStream(), true);

		// 接收控制台数据
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {

		// 提示
		System.out.println("请输入想要说的话：");
		try {
			// 循环输入
			while (true) {

				// 按行读取
				String str = br.readLine();

				// 写数据
				out.write(str + "\n");

				// 刷新
				out.flush();

				// 输入bye 退出程序
				if (str.equals("bye")) {
					System.err.println("Client stop this meeting !");
					// 程序退出
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流
				out.close();
				br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
