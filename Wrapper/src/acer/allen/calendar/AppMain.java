package acer.allen.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AppMain {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GregorianCalendar calendar = new GregorianCalendar(1999, 10, 9, 22, 10, 50);
		GregorianCalendar calendar2 = new GregorianCalendar();
		// Set Date
		calendar2.set(Calendar.YEAR, 2009);
		calendar2.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar2.set(Calendar.DATE, 3);
		calendar2.set(Calendar.HOUR_OF_DAY, 10);
		calendar2.set(Calendar.MINUTE, 20);
		calendar2.set(Calendar.SECOND, 23);
		// 得到相关日期元素
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day2 = calendar.get(Calendar.DATE); // 日：Calendar.DATE和Calendar.DAY_OF_MONTH同义
		int date = calendar.get(Calendar.DAY_OF_WEEK); // 星期几
														// 这里是：1-7.周日是1，周一是2，。。。周六是7
		System.out.printf("%d年%d月%d日,星期%d\n", year, month, day, date);

		// 日期计算
		GregorianCalendar calendar3 = new GregorianCalendar(1999, 10, 9, 22, 10, 50);
		calendar3.add(Calendar.MONTH, -7); // 月份减7
		calendar3.add(Calendar.DATE, 7); // 增加7天
		printCalendar(calendar3);
		// 日历对象和时间对象转化
		Date d = calendar3.getTime();
		long millSecond = calendar3.getTimeInMillis();

		Date date2 = new Date();
		GregorianCalendar calendar4 = new GregorianCalendar();
		calendar4.setTime(date2);

		long g = System.currentTimeMillis();

	}

	@SuppressWarnings("unused")
	static void printCalendar(Calendar calendar) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day2 = calendar.get(Calendar.DATE); // 日：Calendar.DATE和Calendar.DAY_OF_MONTH同义
		int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 星期几
		String week = "" + ((date == 0) ? "日" : date);
		System.out.printf("%d年%d月%d日,星期%s\n", year, month, day, week);
	}
}
