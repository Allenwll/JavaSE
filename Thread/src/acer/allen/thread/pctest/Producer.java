package acer.allen.thread.pctest;

/**
 * 生产者
 * 
 * @author acer
 *
 */
public class Producer implements Runnable {
	// 生产者持有容器的引用
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
