package acer.allen.thread;

public class MyThread {
	private int j = 0;

	public static void main(String[] args) {
		MyThread my = new MyThread();
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
		System.out.println(Thread.currentThread().getName() + "Ôö¼Ó" + j);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void decrease() {
		j--;
		System.out.println(Thread.currentThread().getName() + "¼õÉÙ" + j);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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
