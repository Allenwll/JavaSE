package acer.allen.thread.printnumber;

public class PrintTest {

	public static void main(String[] args) {
		Print p = new Print();
		Thread t1 = new PrintNumber(p);
		Thread t2 = new PrintWord(p);
		t1.start();
		t2.start();

	}

}

class PrintNumber extends Thread {// ��ӡ�����߳�
	private Print p;

	public PrintNumber(Print p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 26; i++) {
			p.printNumber();
		}
	}
}

class PrintWord extends Thread {// ��ӡ��ĸ�߳�
	private Print p;

	public PrintWord(Print p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 26; i++) {
			p.printWord();
		}
	}
}
