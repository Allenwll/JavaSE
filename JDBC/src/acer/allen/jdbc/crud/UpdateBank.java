package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ģ������ת��
 * 
 * @author acer
 *
 */
public class UpdateBank {

	public static void main(String[] args) throws SQLException {

		// driver·��
		String driver = "oracle.jdbc.driver.OracleDriver";

		// url·��
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// ����
		Connection conn = null;

		// ״̬
		PreparedStatement pstate = null;

		// �û���
		String name = "allen";

		// ����
		String pwd = "allen";

		// ��������
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// �������� ͳһ��Դ��λ��,����,����
		try {
			conn = DriverManager.getConnection(url, name, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String update = "update accounts set balance=balance-5000 where userid=1";
		String upSql = "update accounts set balance=balance+5000 where userid=2";

		// �ر��Զ��ύ
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// ִ��SQL���
		try {

			// ����
			pstate = conn.prepareStatement(update);

			// ִ��
			int result = pstate.executeUpdate();

			// ����
			pstate = conn.prepareStatement(upSql);
			// ִ��
			result = pstate.executeUpdate();

			// �ύ
			conn.commit();

			if (result > 0)
				System.out.println("�޸ĳɹ���");
			else {
				System.err.println("�޸�ʧ�ܣ�");
			}
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		pstate.close();
		conn.close();

	}

}
