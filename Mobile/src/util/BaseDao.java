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
 * ��˵����
 *
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version ����ʱ�䣺2016��8��21�� ����1:37:37
 */

public class BaseDao {

	// ����
	private static String driver = null;

	// URL
	private static String url = null;

	// �û���
	private static String user = null;

	// ����
	private static String pwd = null;

	// ����
	private static Connection conn = null;

	// ����ִ����
	private static PreparedStatement pstmt = null;

	/**
	 * ��ȡ�����ļ� ��̬�����
	 */
	static {

		// ��ȡ�����ļ���Ϣ
		InputStream is = BaseDao.class.getResourceAsStream("/conn.properties");

		// �����ļ�
		Properties pr = new Properties();

		try {
			// ��ȡ
			pr.load(is);

		} catch (IOException e) {

			System.err.println("��ȡ�����ļ�ʧ��!!!");
		}

		// ����key��ȡvalue�������ַ�������
		driver = pr.getProperty("driver");

		// ͳһ��Դ��λ��
		url = pr.getProperty("url");

		// �û���
		user = pr.getProperty("user");

		// ����
		pwd = pr.getProperty("pwd");

	}

	/**
	 * ��ȡ����
	 *
	 */
	public static Connection getConn() {

		try {

			// ��������
			Class.forName(driver);

			// ��������
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("��������ʧ��!!!");
		}

		return conn;
	}

	/**
	 * ��ɾ�Ĳ���
	 * 
	 * @return
	 */
	public static int execUpdate(String sql, Object[] obj) {

		// ��¼
		int result = 0;

		try {

			// ��������
			conn = BaseDao.getConn();

			// ����
			pstmt = conn.prepareStatement(sql);

			// ѭ������
			for (int i = 1; i <= obj.length; i++) {

				pstmt.setObject(i, obj[i - 1]);
			}

			// ִ��
			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			System.err.println("�޸ĳ��ִ���������!!!");

		} finally {
			closeAll(null, pstmt, conn);
		}

		// ���ؽ����
		return result;
	}

	/**
	 * �ر�����
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

			System.err.println("�ر��쳣!!!");

		}
	}

}
