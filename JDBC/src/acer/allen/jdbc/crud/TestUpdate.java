package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {

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
		pstate = conn.prepareStatement("update  dept set dName=? where deptno=?");

		// ���ؽ����
		pstate.setString(1, "Market");
		pstate.setInt(2, 50);
		int result = pstate.executeUpdate();

		// ������
		if (result <= 0)
			System.err.println("�޸�ʧ��");
		else
			System.out.println("�޸ĳɹ���");

		// �ر�����
		pstate.close();

		conn.close();

	}

}
