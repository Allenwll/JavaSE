package acer.allen.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarNew {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("请输入日期(格式为：2010-3-3):");
		Scanner s = new Scanner(System.in);
		String dateString = null;
		try {
			dateString = s.nextLine();

			// 将输入的字符串转化成日期类
			System.out.println("您刚刚输入的日期是:" + dateString);
			String[] str = dateString.split("-");
			int year = Integer.parseInt(str[0]);
			int month = new Integer(str[1]);
			int day = new Integer(str[2]);
			GregorianCalendar c = new GregorianCalendar(year, month - 1, day);
			/*
			 * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); Date
			 * date=sdf.parse(dateString); GregorianCalendar c1=new
			 * GregorianCalendar(); c1.setTime(date); int day1 =
			 * c1.get(Calendar.DATE);
			 */
			c.set(Calendar.DATE, 1);
			int dow = c.get(Calendar.DAY_OF_WEEK);// week:1-7 日一二三四五六
			System.out.println("\n日\t一\t二\t三\t四\t五\t六");

			for (int i = 0; i < dow - 1; i++) {
				System.out.print("\t");
			}

			int maxDate = c.getActualMaximum(Calendar.DATE);
			// System.out.println("maxDate:"+maxDate);
			for (int i = 1; i <= maxDate; i++) {
				StringBuilder sBuilder = new StringBuilder();
				if (c.get(Calendar.DATE) == day) {
					sBuilder.append(c.get(Calendar.DATE) + "*\t");
				} else {
					sBuilder.append(c.get(Calendar.DATE) + "\t");
				}
				System.out.print(sBuilder);
				// System.out.print(c.get(Calendar.DATE)+((c.get(Calendar.DATE)==day)?"*":"")+"\t");

				if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
					System.out.print("\n");
				}
				c.add(Calendar.DATE, 1);
			}
		} catch (Exception e) {
			System.err.println("请检查！");
			System.exit(0);
		}
	}

	@SuppressWarnings("unused")
	static void printCalendar(Calendar calendar) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day2 = calendar.get(Calendar.DATE); // 日：Calendar.DATE和Calendar.DAY_OF_MONTH同义
		int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 星期几
		String week = "" + ((date == 0) ? "日" : date);
		System.out.printf("-----%d年%d月%d日,星期%s\n", year, month, day, week);
	}
}
