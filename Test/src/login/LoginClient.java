package login;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * 
 * @author acer
 *
 */
public class LoginClient {

	public static void main(String[] args) {
		// 客户端
		Socket socket;
		// 对象流
		ObjectOutputStream oos = null;
		// 数据输入流
		DataInputStream dis = null;
		Scanner s = null;
		try {
			// 指定客户端主机 和端口
			socket = new Socket("127.0.0.1", 8080);
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("请输入用户名:");
			s = new Scanner(System.in);
			String name = s.nextLine();
			System.out.println("请输入密码:");
			String pwd = s.nextLine();
			oos.writeObject(new User(name, pwd));
			oos.flush();
			dis = new DataInputStream(socket.getInputStream());
			boolean result = dis.readBoolean();

			System.out.println("服务端说:" + (result ? "登陆成功" : "登录失败"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
