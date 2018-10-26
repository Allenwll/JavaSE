package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 类说明：
 *
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version 创建时间：2016年8月21日 下午1:37:37
 */

public class BaseDao {

	// 驱动
	private static String driver = null;

	// URL
	private static String url = null;

	// 用户名
	private static String user = null;

	// 密码
	private static String pwd = null;

	// 连接
	private static Connection conn = null;

	// 命令执行器
	private static PreparedStatement pstmt = null;

	/**
	 * 读取配置文件 静态代码块
	 */
	static {

		// 读取配置文件信息
		InputStream is = BaseDao.class.getResourceAsStream("/conn.properties");

		// 配置文件
		Properties pr = new Properties();

		try {
			// 读取
			pr.load(is);

		} catch (IOException e) {

			System.err.println("读取配置文件失败!!!");
		}

		// 根据key获取value并赋给字符串变量
		driver = pr.getProperty("driver");

		// 统一资源定位符
		url = pr.getProperty("url");

		// 用户名
		user = pr.getProperty("user");

		// 密码
		pwd = pr.getProperty("pwd");

	}

	/**
	 * 获取连接
	 *
	 */
	public static Connection getConn() {

		try {

			// 加载驱动
			Class.forName(driver);

			// 建立连接
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("驱动加载失败!!!");
		}

		return conn;
	}

	/**
	 * 增删改操作
	 * 
	 * @return
	 */
	public static int execUpdate(String sql, Object[] obj) {

		// 记录
		int result = 0;

		try {

			// 建立连接
			conn = BaseDao.getConn();

			// 发送
			pstmt = conn.prepareStatement(sql);

			// 循环设置
			for (int i = 1; i <= obj.length; i++) {

				pstmt.setObject(i, obj[i - 1]);
			}

			// 执行
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			System.err.println("修改出现错误，请重试!!!");

		} finally {
			closeAll(null, pstmt, conn);
		}

		// 返回结果集
		return result;
	}

	/**
	 * 关闭连接
	 */
	public static void closeAll(ResultSet rs, PreparedStatement psmt, Connection conn) {

		try {

			if (rs != null)
				rs.close();

			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {

			System.err.println("关闭异常!!!");

		}
	}

}
