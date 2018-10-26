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
		// �õ��������Ԫ��
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day2 = calendar.get(Calendar.DATE); // �գ�Calendar.DATE��Calendar.DAY_OF_MONTHͬ��
		int date = calendar.get(Calendar.DAY_OF_WEEK); // ���ڼ�
														// �����ǣ�1-7.������1����һ��2��������������7
		System.out.printf("%d��%d��%d��,����%d\n", year, month, day, date);

		// ���ڼ���
		GregorianCalendar calendar3 = new GregorianCalendar(1999, 10, 9, 22, 10, 50);
		calendar3.add(Calendar.MONTH, -7); // �·ݼ�7
		calendar3.add(Calendar.DATE, 7); // ����7��
		printCalendar(calendar3);
		// ���������ʱ�����ת��
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
		int day2 = calendar.get(Calendar.DATE); // �գ�Calendar.DATE��Calendar.DAY_OF_MONTHͬ��
		int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // ���ڼ�
		String week = "" + ((date == 0) ? "��" : date);
		System.out.printf("%d��%d��%d��,����%s\n", year, month, day, week);
	}
}
