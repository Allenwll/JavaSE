package thread.priority;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * 
 * 用到 sleep sleep 中的时间是毫秒
 * 
 * @author acer
 *
 */
public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		DateFormat df = new SimpleDateFormat("yy年MM月dd日HH时mm分ss秒");
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
	 * 倒计时
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
