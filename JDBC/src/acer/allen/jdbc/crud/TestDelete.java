package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDelete {

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
		pstate = conn.prepareStatement("delete dept where deptno=?");
		pstate.setInt(1, 50);

		// ���ؽ����
		int result = pstate.executeUpdate();

		// ������
		if (result > 0)
			System.out.println("ɾ���ɹ���");
		else
			System.err.println("ɾ��ʧ��");

		// �ر�����
		pstate.close();

		conn.close();

	}

}
