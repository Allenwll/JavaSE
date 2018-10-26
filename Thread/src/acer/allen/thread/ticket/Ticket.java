package acer.allen.thread.ticket;

/**
 * �߳�ͬ�� synchronized ������ �ȴ� ���� �������� ���� �˳�������
 * 
 * ͬ������� synchronized(�������Ͷ���) ����Ψһ
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
			 * System.out.println(Thread.currentThread().getName() + "���ĵ�" +
			 * (500 - ticketCount + 1) + "��Ʊ!��ʣ" + (--ticketCount) + "�ţ�"); }
			 * else { System.err.println("Ʊ��������"); break; }
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
			System.out.println(Thread.currentThread().getName() + "���ĵ�" + (500 - ticketCount + 1) + "��Ʊ!��ʣ"
					+ (--ticketCount) + "�ţ�");
			return false;
		} else {
			System.err.println("Ʊ��������");
			return true;
		}
	}
}
