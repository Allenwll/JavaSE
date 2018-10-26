package thread.pc;

public class Test {

	public static void main(String[] args) {
		SyncStack s = new SyncStack();
		Producer p = new Producer(s);
		new Thread(p).start();
		Consumer c = new Consumer(s);
		new Thread(c).start();
	}

}
