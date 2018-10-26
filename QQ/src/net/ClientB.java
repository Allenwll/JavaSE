package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 客户B
 * 
 * @author acer
 *
 */
public class ClientB {

	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建客户端对象
		Socket socket = null;

		try {
			// 指定连接端口和IP地址
			socket = new Socket("127.0.0.1", 8000);
			
			// 开启发送数据线程
			new ClientSendThread(socket).start();
			
			// 读取数据
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.equals("bye")) {
					System.err.println("结束会话");
					System.exit(0);
				}
				line = br.readLine();
			}
			br.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

/**
 * 发送信息线程
 * 
 * @author acer
 *
 */
class ClientSendThread extends Thread {

	// 客户端对象
	Socket socket = null;

	// 字符缓冲读入流
	BufferedReader br = null;

	// 字符缓冲写出流
	BufferedWriter bw = null;

	public ClientSendThread(Socket socket) throws IOException {

		this.socket = socket;

		// 实例化读入流
		br = new BufferedReader(new InputStreamReader(System.in));

		// 实例化写出流
		bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
	}

	@Override
	public void run() {
		// 提示
		System.err.println("请输入你想要说的话:");

		// 循环读取
		while (true) {
			try {

				// 按行读取
				String temp = br.readLine();

				System.out.println("我说:" + temp);
				// 写入
				bw.write("B说："+temp);
				
				//另起一行
				bw.newLine();
				
				// 刷新
				bw.flush();

				// 判断是否输入bye
				if (temp.equals("bye")) {

					System.out.println("终止会话.");
					// 退出程序
					System.exit(0);
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			// 关闭流对象
			bw.close();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}