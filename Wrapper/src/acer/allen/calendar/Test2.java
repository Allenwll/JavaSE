package acer.allen.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SuppressWarnings("unused")
public class Test2 {

	public static void main(String[] args) {
		/*
		 * Date date = new Date(); // �ַ�����date java.sql.Date date1 =
		 * java.sql.Date.valueOf("1992-7-7");
		 * System.out.println(date1.toString());
		 * 
		 * DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // hh
		 * ���� // 12Сʱ�� // HH // ����24Сʱ�� System.out.println(sdf.format(date));
		 * 
		 * showString();
		 */
		showExit();
	}

	static void showString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			int result = new Random().nextInt(10);
			sb.append("" + result);
		}
		System.out.println("�ɱ��ַ������У�" + sb);
		for (int i = 0; i < sb.length(); i++) {
			int result = Integer.valueOf(sb.charAt(i));
			if (result % 2 != 0) {
				sb.deleteCharAt(i);
				i--;
			}

		}
		System.out.println("ȥ����������ַ�����Ϊ��" + sb);
		
		
	}

	static void showExit() {
		int i = 10;
		long time = System.currentTimeMillis();
		long temp=-1;
		while (true) {
			if (System.currentTimeMillis() - time >= 1000) {
				System.out.println("����ʱ:" + i);
				i--;
				if (i <= 0) {
					System.err.println("�����˳�");
					return;
				}
				time = System.currentTimeMillis();
			}
		}
	}

}
