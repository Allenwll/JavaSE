package thread.ticket;

public class Ticket implements Runnable {
	private static Object object = new Object();
	private int ticketCount = 100;

	@Override
	public void run() {
		while (true) {
			synchronized (object) {
				if (ticketCount > 0) {
					System.out.println(Thread.currentThread().getName() + "����" + (101 - ticketCount) + "�Ż�Ʊ����ʣ"
							+ (--ticketCount) + "��Ʊ��");
				} else {
					System.out.println("��Ʊ�Ѿ�������");
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
