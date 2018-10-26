package thread.priority;

/**
 * Description 测试线程的优先级 1-10 默认为5
 * 
 * @author acer
 *
 */
public class TestPriority {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		thread1.start();
		thread1.setPriority(10);
		Thread2 thread2 = new Thread2();
		thread2.start();
		thread2.setPriority(Thread.MIN_PRIORITY);
	}

}

class Thread1 extends Thread {
	int i = 0;

	@Override
	public void run() {
		while (true)
			System.out.println(
					this.getPriority() + "--------------------------------" + this.getName() + "-----" + (i++));
	}
}

class Thread2 extends Thread {
	int i = 0;

	@Override
	public void run() {
		while (true)
			System.out.println(
					this.getPriority() + "*********************************" + this.getName() + "-----" + (i++));
	}
}
