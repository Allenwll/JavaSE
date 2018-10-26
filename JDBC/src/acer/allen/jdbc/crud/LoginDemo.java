package acer.allen.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args) throws Exception {

		// ����
		String driver = "oracle.jdbc.driver.OracleDriver";

		// ͳһ��Դ��λ��
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";

		// ����
		Connection conn = null;

		// �������
		PreparedStatement pState = null;

		// �����
		ResultSet rs = null;

		String uname = "allen";

		String upwd = "allen";

		// �õ�����̨
		Scanner sc = new Scanner(System.in);

		// �õ��û���
		System.out.println("�������û���:");
		String name = sc.nextLine();

		// �õ�����
		System.out.println("����������:");
		String pwd = sc.nextLine();

		// ��������
		Class.forName(driver);

		// ��������
		conn = DriverManager.getConnection(url, uname, upwd);

		// �������
		pState = conn.prepareStatement("select * from login where userid=? and pwd=?");
		pState.setString(1, name);
		pState.setString(2, pwd);

		// ִ�������
		rs = pState.executeQuery();

		// ���岼��ֵ
		boolean flag = false;

		// ��ȡ����
		while (rs.next()) {
			flag = true;
		}

		if (flag)
			System.out.println("��¼�ɹ���");
		else {
			System.err.println("�û��������벻ƥ��!");
		}

		// �ر�
		rs.close();
		pState.close();
		conn.close();
		sc.close();
	}

}
