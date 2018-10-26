package thread.priority;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ
 * 
 * �õ� sleep sleep �е�ʱ���Ǻ���
 * 
 * @author acer
 *
 */
public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		DateFormat df = new SimpleDateFormat("yy��MM��dd��HHʱmm��ss��");
		while (true) {
			long time = System.currentTimeMillis();
			Date date = new Date();
			String str = df.format(date);
			System.err.println(str);
			long dis = System.currentTimeMillis() - time;
			Thread.sleep(1000 - dis);
		}
	}

	/**
	 * ����ʱ
	 * 
	 * @throws InterruptedException
	 */
	static void countDown() throws InterruptedException {
		System.out.println("Are you  ready ?");
		for (int i = 3; i > 0; i--) {
			System.err.println(i);
			Thread.sleep(1000);
		}
		System.out.println("GO !");
	}
}
