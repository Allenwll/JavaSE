package thread.priority;

/**
 * yield 让出当前现场的CPU的使用权，进入就绪状态，让CPU重新选择一个线程进入运行状态 非阻塞
 * 
 * 如果就绪队列中没有任何的线程等待，那么直接进入运行状态
 * 
 * @author acer
 *
 */
public class TestYield {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyThread().start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "------------------------" + Thread.currentThread().getName());
			Thread.yield();
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "------------------------" + getName());
			yield();
		}
	}
}
