package acer.allen.thread.ticket;

/**
 * 线程同步 synchronized 有锁， 等待 无锁 ，加锁， 进入 退出，解锁
 * 
 * 同步代码块 synchronized(引用类型对象) 必须唯一
 * 
 * @author acer
 *
 */
public class Ticket implements Runnable {
	private int ticketCount = 500;

	@SuppressWarnings("unused")
	private static Object object = new Object();

	public Ticket() {
		super();
	}

	@Override
	public void run() {
		while (true) {
			/*
			 * synchronized (object) { if (ticketCount > 0) {
			 * System.out.println(Thread.currentThread().getName() + "卖的第" +
			 * (500 - ticketCount + 1) + "张票!还剩" + (--ticketCount) + "张！"); }
			 * else { System.err.println("票已售罄。"); break; }
			 */
			boolean result = saleTickets();
			if (result)
				break;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized boolean saleTickets() {
		if (ticketCount > 0) {
			System.out.println(Thread.currentThread().getName() + "卖的第" + (500 - ticketCount + 1) + "张票!还剩"
					+ (--ticketCount) + "张！");
			return false;
		} else {
			System.err.println("票已售罄。");
			return true;
		}
	}
}
