package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args) throws Exception {

		// 驱动
		String driver = "oracle.jdbc.driver.OracleDriver";

		// 统一资源定位符
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// 连接
		Connection conn = null;

		// 命令发送器
		PreparedStatement pState = null;

		// 结果集
		ResultSet rs = null;

		String uname = "allen";

		String upwd = "allen";

		// 得到控制台
		Scanner sc = new Scanner(System.in);

		// 得到用户名
		System.out.println("请输入用户名:");
		String name = sc.nextLine();

		// 得到密码
		System.out.println("请输入密码:");
		String pwd = sc.nextLine();

		// 加载驱动
		Class.forName(driver);

		// 建立连接
		conn = DriverManager.getConnection(url, uname, upwd);

		// 命令发送器
		pState = conn.prepareStatement("select * from login where userid=? and pwd=?");
		pState.setString(1, name);
		pState.setString(2, pwd);

		// 执行命令发送
		rs = pState.executeQuery();

		// 定义布尔值
		boolean flag = false;

		// 读取数据
		while (rs.next()) {
			flag = true;
		}

		if (flag)
			System.out.println("登录成功！");
		else {
			System.err.println("用户名与密码不匹配!");
		}

		// 关闭
		rs.close();
		pState.close();
		conn.close();
		sc.close();
	}

}
