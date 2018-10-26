package acer.allen.thread.pctest;

/**
 * ������
 * 
 * @author acer
 *
 */
public class Producer implements Runnable {
	// �����߳�������������
	SyncStack stack = null;

	public Producer(SyncStack stack) {
		super();
		this.stack = stack;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				this.stack.push(new SteamBread(i+1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
