package printer;

/**
 * ��ӡ��
 * 
 * @author acer
 *
 */
public class Print {

	// ��ӡ����
	private int index = 1;

	/**
	 * ��ӡ����
	 * 
	 * @param i
	 * @throws InterruptedException
	 */
	synchronized void print(int i) throws InterruptedException {
		if (index % 3 == 0) {
			wait();
			index++;
			System.out.print(i);
		} else {
			index++;
			System.out.print(i);
			notifyAll();
		}
	}

	/**
	 * ��ӡ�ַ�
	 * 
	 * @param c
	 * @throws InterruptedException
	 */
	synchronized void print(char c) throws InterruptedException {
		if (index % 3 != 0) {
			notify();
			wait();
			System.out.print(c);
			index++;
		} else {
			System.out.print(c);
			index++;
			notifyAll();
		}
	}

}

/**
 * �����߳���
 * 
 * @author acer
 *
 */
class NumberPrinter extends Thread {
	private Print p;

	public NumberPrinter(Print p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 1; i < 53; i++) {
			try {
				p.print(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

/**
 * �ַ��߳���
 * 
 * @author acer
 *
 */
class LetterPrinter extends Thread {
	private Print p;

	public LetterPrinter(Print p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 26; i++) {
			try {
				p.print((char)(i + 'A'));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
