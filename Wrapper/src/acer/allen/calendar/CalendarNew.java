package acer.allen.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarNew {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("����������(��ʽΪ��2010-3-3):");
		Scanner s = new Scanner(System.in);
		String dateString = null;
		try {
			dateString = s.nextLine();

			// ��������ַ���ת����������
			System.out.println("���ո������������:" + dateString);
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
			int dow = c.get(Calendar.DAY_OF_WEEK);// week:1-7 ��һ����������
			System.out.println("\n��\tһ\t��\t��\t��\t��\t��");

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
			System.err.println("���飡");
			System.exit(0);
		}
	}

	@SuppressWarnings("unused")
	static void printCalendar(Calendar calendar) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day2 = calendar.get(Calendar.DATE); // �գ�Calendar.DATE��Calendar.DAY_OF_MONTHͬ��
		int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // ���ڼ�
		String week = "" + ((date == 0) ? "��" : date);
		System.out.printf("-----%d��%d��%d��,����%s\n", year, month, day, week);
	}
}
