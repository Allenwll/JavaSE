package ticket;

/**
 * 火车票
 * 
 * @author acer
 *
 */
public class Ticket {

	/**
	 * 程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 实例化售票线程
		SaleTicket st = new SaleTicket();

		// 循环6次 生成6个线程
		for (int i = 1; i < 6; i++) {
			// 开启线程
			new Thread(st, "售票点" + i).start();
		}
	}
}

/**
 * 卖票线程
 * 
 * @author acer
 *
 */
class SaleTicket implements Runnable {

	// 总票数
	private static int countTicket = 100;

	// 已售票数
	private static int index = 0;

	@Override
	public void run() {

		// 循环
		while (true) {

			// 同步代码块
			synchronized (this) {

				// 总票数减1
				countTicket--;

				// 已售票数加1
				index++;

				// 票卖完的情况
				if (countTicket > 0) {

					// 显示
					System.out.println(Thread.currentThread().getName() + "已售" + index + "张，还剩余" + countTicket + "张");
				} else {
					// 提示
					System.err.println("票已售罄！改日再来。");

					// 退出程序
					System.exit(0);
				}
				try {
					// 线程休眠100毫秒，休眠时 并不释放对象锁
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
