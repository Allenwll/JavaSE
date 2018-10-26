package QQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {

		service();
	}

	private static void service() throws IOException {
		ServerSocket server = null;
		try {
			server = new ServerSocket(8080);
			System.err.println("-------------等待客户端连接------------");

			while (true) {
				Socket socket = server.accept();
				System.out.println("客户端连接成功！");
				new SendServerThread(socket).start();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					String line = br.readLine();

					if (line == null)
						break;
					System.out.println("服务器说:" + line);

				}

			}
		} catch (Exception e) {
			server.close();
		}
	}

}

class SendServerThread extends Thread {

	Socket socket;
	BufferedReader br = null;
	BufferedWriter bw = null;

	public SendServerThread(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	@Override
	public void run() {
		String line = null;
		System.out.println("请输入你想要说的话！");
		try {
			while (true) {
				line = br.readLine();
				bw.write(line);
				bw.newLine();
				bw.flush();
				if (line == null)
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}