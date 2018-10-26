package thread.pc;

public class SyncStack {
	SteamBread[] breads = new SteamBread[6];
	
	private int index;

	public SteamBread[] getBreads() {
		return breads;
	}

	public void setBreads(SteamBread[] breads) {
		this.breads = breads;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	synchronized void push(SteamBread bread) throws InterruptedException {
		if (index == breads.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		breads[index] = bread;
		index++;
		System.out.println("生产者生产了" + bread);
		notify();
		Thread.sleep(1000);
	}

	synchronized void pop() throws InterruptedException {
		if (index == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		index--;
		System.out.println("消费者消费了" + breads[index]);
		notify();
		Thread.sleep(1000);
	}

}
