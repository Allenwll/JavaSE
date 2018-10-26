package acer.allen.thread.printnumber;

public class Print {

	private int i = 1;
	private char j = 'A';

	public Print() {
	}

	public synchronized void printNumber() {// 同步方法
		System.out.print(String.valueOf(i) + String.valueOf(i + 1));
		i += 2;
		notifyAll(); // 先唤醒其他进程，再阻塞本进程，如果顺序颠倒了，进程阻塞后不能再唤醒其他进程
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void printWord() {
		System.out.print(j);
		j++;
		notifyAll();
		try {
			if (j <= 'Z')// 输出Z之后就不用再等待了。
			{

				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}