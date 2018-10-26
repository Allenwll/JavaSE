package thread.shownum;

public class Test {

	public static void main(String[] args) {
		/*
		 * new Thread1().start(); new Thread2().start();
		 */
		Test t = new Test();
		Thread3 t3 = t.new Thread3();
		Thread4 t4 = t.new Thread4();
		Thread t1 = new Thread(t3);
		t1.start();
		Thread t2 = new Thread(t4);
		t2.start();
	}

	synchronized void evenNumber(int i) throws InterruptedException {
		if (i % 2 == 0) {
			System.out.println(Thread.currentThread().getName() + " " + i + "偶数");
		}
		Thread.sleep(1000);
	}

	synchronized void oddNumber(int i) throws InterruptedException {
		if (i % 2 != 0) {
			System.out.println(Thread.currentThread().getName() + " " + i + "奇数");
		}
		Thread.sleep(1000);
	}

	class Thread3 implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					oddNumber(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	class Thread4 implements Runnable {

		@Override
		public void run() {
			for (int i = 100; i >0; i--) {
				try {
					evenNumber(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}

class Thread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				oddNumber(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized void oddNumber(int i) throws InterruptedException {
		if (i % 2 != 0) {
			System.out.println(Thread.currentThread().getName() + " " + i + "奇数");
		}
		Thread.sleep(1000);
	}

}

class Thread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				evenNumber(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	synchronized void evenNumber(int i) throws InterruptedException {
		if (i % 2 == 0) {
			System.out.println(Thread.currentThread().getName() + " " + i + "偶数");
		}
		Thread.sleep(1000);
	}
}