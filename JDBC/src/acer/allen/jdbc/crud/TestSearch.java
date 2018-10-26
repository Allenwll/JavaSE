package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSearch {

	public static void main(String[] args) throws Exception {

		// driver·��
		String driver = "oracle.jdbc.driver.OracleDriver";

		// url·��
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// ����
		Connection conn = null;

		// ״̬
		PreparedStatement pstate = null;// Statement state = null;

		// �û���
		String name = "scott";

		// ����

		String pwd = "tiger";

		// ����� ����Query ��ѯ ���ؽ����
		ResultSet rs = null;

		// ��ѯ�ַ���
		String querySql = "";

		// ����
		Class.forName(driver);

		// ����
		conn = DriverManager.getConnection(url, name, pwd);

		querySql = "select * from dept";

		// ִ��SQL
		pstate = conn.prepareStatement(querySql);
		// state =conn.createStatement();

		// ���ؽ����
		rs = pstate.executeQuery(); // rs =state.executeQuery(querySql);

		System.err.println("���ű��\t\t��������\t\t\t���ŵص�");

		// ������

		while (rs.next()) {

			// ȡ����������
			int id = rs.getInt("deptno");

			// ��������
			String dname = rs.getString(2);

			// ���ŵص�
			String loc = rs.getString(3);

			// ��ӡ
			System.out.println(id + "\t\t" + dname + "    \t\t" + loc);

		}

		querySql = "select empno Ա����� ,ename Ա������,hiredate ��ְʱ��,sal нˮ,comm ���� from emp order by empno ";

		//pstate = conn.prepareStatement(querySql);

		pstate = conn.prepareStatement(querySql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = pstate.executeQuery();
		
		System.err.println("\n\nԱ�����\tԱ������\t\t��ְ����\t\t\tнˮ\t����");
		rs.last();
		while (rs.previous()) {

			int id = rs.getInt("Ա�����");

			String ename = rs.getString(2);

			Date date = rs.getDate("��ְʱ��");

			int sal = (int) rs.getDouble("нˮ");

			int comm = rs.getInt(5);

			System.out.println(id + "\t" + ename + "\t\t" + date + "\t\t" + sal + "\t" + comm);
		}

		// �ر�
		if (rs != null)

			rs.close();// state.close();

		if (pstate != null)

			pstate.close();

		if (conn != null)

			conn.close();

	}

}
