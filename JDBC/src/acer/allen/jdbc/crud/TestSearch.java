package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSearch {

	public static void main(String[] args) throws Exception {

		// driver路径
		String driver = "oracle.jdbc.driver.OracleDriver";

		// url路径
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// 连接
		Connection conn = null;

		// 状态
		PreparedStatement pstate = null;// Statement state = null;

		// 用户名
		String name = "scott";

		// 密码

		String pwd = "tiger";

		// 结果集 用于Query 查询 返回结果集
		ResultSet rs = null;

		// 查询字符串
		String querySql = "";

		// 加载
		Class.forName(driver);

		// 连接
		conn = DriverManager.getConnection(url, name, pwd);

		querySql = "select * from dept";

		// 执行SQL
		pstate = conn.prepareStatement(querySql);
		// state =conn.createStatement();

		// 返回结果集
		rs = pstate.executeQuery(); // rs =state.executeQuery(querySql);

		System.err.println("部门编号\t\t部门名称\t\t\t部门地点");

		// 处理结果

		while (rs.next()) {

			// 取出各列数据
			int id = rs.getInt("deptno");

			// 部门名称
			String dname = rs.getString(2);

			// 部门地点
			String loc = rs.getString(3);

			// 打印
			System.out.println(id + "\t\t" + dname + "    \t\t" + loc);

		}

		querySql = "select empno 员工编号 ,ename 员工姓名,hiredate 入职时间,sal 薪水,comm 津贴 from emp order by empno ";

		//pstate = conn.prepareStatement(querySql);

		pstate = conn.prepareStatement(querySql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = pstate.executeQuery();
		
		System.err.println("\n\n员工编号\t员工姓名\t\t入职日期\t\t\t薪水\t津贴");
		rs.last();
		while (rs.previous()) {

			int id = rs.getInt("员工编号");

			String ename = rs.getString(2);

			Date date = rs.getDate("入职时间");

			int sal = (int) rs.getDouble("薪水");

			int comm = rs.getInt(5);

			System.out.println(id + "\t" + ename + "\t\t" + date + "\t\t" + sal + "\t" + comm);
		}

		// 关闭
		if (rs != null)

			rs.close();// state.close();

		if (pstate != null)

			pstate.close();

		if (conn != null)

			conn.close();

	}

}
