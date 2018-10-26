package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 模拟银行转账
 * 
 * @author acer
 *
 */
public class UpdateBank {

	public static void main(String[] args) throws SQLException {

		// driver路径
		String driver = "oracle.jdbc.driver.OracleDriver";

		// url路径
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// 连接
		Connection conn = null;

		// 状态
		PreparedStatement pstate = null;

		// 用户名
		String name = "allen";

		// 密码
		String pwd = "allen";

		// 加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 建立连接 统一资源定位符,名字,密码
		try {
			conn = DriverManager.getConnection(url, name, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String update = "update accounts set balance=balance-5000 where userid=1";
		String upSql = "update accounts set balance=balance+5000 where userid=2";

		// 关闭自动提交
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// 执行SQL语句
		try {

			// 返回
			pstate = conn.prepareStatement(update);

			// 执行
			int result = pstate.executeUpdate();

			// 返回
			pstate = conn.prepareStatement(upSql);
			// 执行
			result = pstate.executeUpdate();

			// 提交
			conn.commit();

			if (result > 0)
				System.out.println("修改成功！");
			else {
				System.err.println("修改失败！");
			}
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		pstate.close();
		conn.close();

	}

}
