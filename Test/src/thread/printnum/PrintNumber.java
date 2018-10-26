package thread.printnum;

public class PrintNumber {

	public static void main(String[] args) {
		PrintNumber p = new PrintNumber();
		PrintNum p1 = new PrintNum(p);
		PrintChar pc = new PrintChar(p);
		new Thread(p1).start();
		new Thread(pc).start();
	}

}

class PrintNum implements Runnable {

	private PrintNumber p;

	public PrintNum(PrintNumber p) {
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			for (int i = 1; i < 53; i++) {
				System.out.print(i + "");
				if (i % 2 == 0) {
					p.notifyAll();
					try {
						p.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class PrintChar implements Runnable {
	private PrintNumber p;

	public PrintChar(PrintNumber p) {
		this.p = p;
	}

	@Override
	public void run() {
		synchronized (p) {
			for (int i = 0; i < 26; i++) {
				System.out.print((char) (i + 'A') + "");
				p.notifyAll();
				try {
					if (i != 25)
						p.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
