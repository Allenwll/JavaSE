package ticket;

/**
 * ��Ʊ
 * 
 * @author acer
 *
 */
public class Ticket {

	/**
	 * ��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// ʵ������Ʊ�߳�
		SaleTicket st = new SaleTicket();

		// ѭ��6�� ����6���߳�
		for (int i = 1; i < 6; i++) {
			// �����߳�
			new Thread(st, "��Ʊ��" + i).start();
		}
	}
}

/**
 * ��Ʊ�߳�
 * 
 * @author acer
 *
 */
class SaleTicket implements Runnable {

	// ��Ʊ��
	private static int countTicket = 100;

	// ����Ʊ��
	private static int index = 0;

	@Override
	public void run() {

		// ѭ��
		while (true) {

			// ͬ�������
			synchronized (this) {

				// ��Ʊ����1
				countTicket--;

				// ����Ʊ����1
				index++;

				// Ʊ��������
				if (countTicket > 0) {

					// ��ʾ
					System.out.println(Thread.currentThread().getName() + "����" + index + "�ţ���ʣ��" + countTicket + "��");
				} else {
					// ��ʾ
					System.err.println("Ʊ������������������");

					// �˳�����
					System.exit(0);
				}
				try {
					// �߳�����100���룬����ʱ �����ͷŶ�����
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
