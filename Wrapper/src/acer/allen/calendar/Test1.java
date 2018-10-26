package acer.allen.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
		Date date1 = new Date(0);
		System.out.println(date1.toString());
		long i = date1.getTime();
		Date date2 = new Date(i - 1000);
		Date date3 = new Date(i + 1000);
		System.out.println(date1.after(date2));
		System.out.println(date1.before(date2));
		System.out.println(date1.equals(date2));
		System.out.println(date1.after(date3));
		System.out.println(date1.before(date3));
		System.out.println(new Date(1000L * 60 * 60 * 24 * 365 * 39L).toString());
		// new��SimpleDateFormat����
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");

		// ��ʱ�����ת�����ַ���
		String daytime = s1.format(new Date());
		System.out.println(s2.format(new Date()));
		System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));

		// ������ָ����ʽ���ַ���ת�ɳ�ʱ�����.�ַ�����ʽ��Ҫ��ָ����ʽһ�¡�
		String time = "2007-10-7";
		Date date = s2.parse(time);
		System.out.println("date1: " + s2.format(date));
		time = "2007-10-7 20:15:30";
		date = s1.parse(time);
		System.out.println("date2: " + date);
	}
}
