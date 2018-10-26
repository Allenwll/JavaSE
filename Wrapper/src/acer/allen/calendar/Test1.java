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
		// new出SimpleDateFormat对象
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");

		// 将时间对象转换成字符串
		String daytime = s1.format(new Date());
		System.out.println(s2.format(new Date()));
		System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));

		// 将符合指定格式的字符串转成成时间对象.字符串格式需要和指定格式一致。
		String time = "2007-10-7";
		Date date = s2.parse(time);
		System.out.println("date1: " + s2.format(date));
		time = "2007-10-7 20:15:30";
		date = s1.parse(time);
		System.out.println("date2: " + date);
	}
}
