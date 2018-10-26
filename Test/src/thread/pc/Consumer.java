package thread.pc;

public class Consumer implements Runnable {
	SyncStack stack = null;

	public Consumer(SyncStack stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				this.stack.pop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
