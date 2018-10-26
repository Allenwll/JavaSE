package thread;



/**
 * 两个线程每次对j增加1，另外两个线程对j每次减少1
 * 
 * @author acer
 *
 */
public class ShowNum {

	private int j = 0;

	public static void main(String[] args) {
		ShowNum my = new ShowNum();
		Increase in = my.new Increase();
		Decrease de = my.new Decrease();
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(in);
			t.start();
			t = new Thread(de);
			t.start();
		}
	}

	synchronized void increase() {
		j++;
		System.out.println(Thread.currentThread().getName() + "增加" + j);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized void decrease() {
		j--;
		System.out.println(Thread.currentThread().getName() + "减少" + j);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class Increase implements Runnable {
		@Override
		public void run() {
			while (true) {
				increase();
			}
		}
	}

	class Decrease implements Runnable {
		@Override
		public void run() {
			while (true) {
				decrease();
			}
		}
	}
}
