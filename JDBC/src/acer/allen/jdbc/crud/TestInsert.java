package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// driver·��
		String driver = "oracle.jdbc.driver.OracleDriver";

		// url·��
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// ����
		Connection conn = null;

		// ״̬
		PreparedStatement pstate = null;

		// �û���
		String name = "scott";

		// ����
		String pwd = "tiger";

		// ��������
		Class.forName(driver);

		// �������� ͳһ��Դ��λ��,����,����
		conn = DriverManager.getConnection(url, name, pwd);

		// ִ��SQL���
		pstate = conn.prepareStatement("insert into dept(DEPTNO,DNAME,LOC) values(?,?,?)");

		// ���ؽ����
		pstate.setInt(1, 50);
		pstate.setString(2, "Ӫ����");
		pstate.setString(3, "�Ͼ�");

		int result = pstate.executeUpdate();

		// ������
		if (result <= 0)
			System.err.println("����ʧ��");
		else
			System.out.println("����ɹ���");

		// �ر�����
		pstate.close();

		conn.close();

	}

}
