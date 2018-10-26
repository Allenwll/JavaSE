package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// driver路径
		String driver = "oracle.jdbc.driver.OracleDriver";

		// url路径
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// 连接
		Connection conn = null;

		// 状态
		PreparedStatement pstate = null;

		// 用户名
		String name = "scott";

		// 密码
		String pwd = "tiger";

		// 加载驱动
		Class.forName(driver);

		// 建立连接 统一资源定位符,名字,密码
		conn = DriverManager.getConnection(url, name, pwd);

		// 执行SQL语句
		pstate = conn.prepareStatement("insert into dept(DEPTNO,DNAME,LOC) values(?,?,?)");

		// 返回结果集
		pstate.setInt(1, 50);
		pstate.setString(2, "营销部");
		pstate.setString(3, "南京");

		int result = pstate.executeUpdate();

		// 处理结果
		if (result <= 0)
			System.err.println("插入失败");
		else
			System.out.println("插入成功！");

		// 关闭连接
		pstate.close();

		conn.close();

	}

}
