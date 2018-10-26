package acer.allen.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SuppressWarnings("unused")
public class Test2 {

	public static void main(String[] args) {
		/*
		 * Date date = new Date(); // 字符串到date java.sql.Date date1 =
		 * java.sql.Date.valueOf("1992-7-7");
		 * System.out.println(date1.toString());
		 * 
		 * DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // hh
		 * 代表 // 12小时制 // HH // 代表24小时制 System.out.println(sdf.format(date));
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
		System.out.println("可变字符串序列：" + sb);
		for (int i = 0; i < sb.length(); i++) {
			int result = Integer.valueOf(sb.charAt(i));
			if (result % 2 != 0) {
				sb.deleteCharAt(i);
				i--;
			}

		}
		System.out.println("去除奇数后的字符序列为：" + sb);
		
		
	}

	static void showExit() {
		int i = 10;
		long time = System.currentTimeMillis();
		long temp=-1;
		while (true) {
			if (System.currentTimeMillis() - time >= 1000) {
				System.out.println("倒计时:" + i);
				i--;
				if (i <= 0) {
					System.err.println("程序退出");
					return;
				}
				time = System.currentTimeMillis();
			}
		}
	}

}
