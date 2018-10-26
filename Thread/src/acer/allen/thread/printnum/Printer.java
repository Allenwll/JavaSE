package acer.allen.thread.printnum;

/**
 * 打印类
 * 
 * @author acer
 *
 */

public class Printer {
	// 打印次数
	private int index = 1;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Printer() {
		super();
	}

	/**
	 * 打印数字方法
	 * 
	 * @param 数字
	 * @return
	 */
	public synchronized void print(int i) {
		if (index % 3 == 0) {
			try {
				wait();
				index++;
				System.out.print(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			index++;
			System.out.print(i);
			notifyAll();
		}

	}

	/**
	 * 打印字母方法
	 * 
	 * @param 字符
	 * @throws InterruptedException
	 */
	public synchronized void print(char c) throws InterruptedException {

		if (index % 3 != 0) {
			notifyAll();
			wait();
			index++;
			System.out.print(c);
		} else {
			System.out.print(c);
			index++;
		}

	}

}

class NumberPrinter extends Thread {
	private Printer p;

	public NumberPrinter(Printer p) {
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			for (int i = 1; i < 53; i++) {
				p.print(i);
			}
		}

	}
}

class LetterPrinter extends Thread {
	private Printer p;

	public LetterPrinter(Printer p) {
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			for (int i = 0; i < 26; i++) {
				try {
					p.print((char) (i + 'A'));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}