package thread.ticket;

public class Ticket implements Runnable {
	private static Object object = new Object();
	private int ticketCount = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (object) {
				if (ticketCount > 0) {
					System.out.println(Thread.currentThread().getName() + "已售" + (101 - ticketCount) + "张火车票，还剩"
							+ (--ticketCount) + "张票。");
				} else {
					System.out.println("火车票已经售罄！");
					break;
				}

			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
