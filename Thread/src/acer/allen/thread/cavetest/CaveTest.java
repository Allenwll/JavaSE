package acer.allen.thread.cavetest;

public class CaveTest {
	private String[] name;
	private int count = 1;
	public CaveTest() {
		String[] name = { "Allen", "Mars", "Judy", "Any", "Sunny", "Bobi", "Mini", "Pink", "Yobu", "Zippes" };
		this.name = name;
	}

	public static void main(String[] args) throws InterruptedException {
		CaveTest t = new CaveTest();
		t.SendAllNames();
	}

	public synchronized void PrintName(String name) {
		// 延迟5s，模拟过山洞的时间为5s
		System.out.println(name + "---------------------第" + count + "个通过山洞\n");
		count++;
		try {
			for (int i = 5; i > 0; i--) {
				System.err.println("\n"+i+"\n");
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 将10个人名分给10个线程，模拟10个人
	public void SendAllNames() {
		for (int i = 0; i < name.length; i++) {
			CaveThread gt = new CaveThread(this, name[i]);
			gt.start();
		}
	}
}

class CaveThread extends Thread {
	private CaveTest tcave;
	private String name;

	public CaveThread() {
		// TODO Auto-generated constructor stub
	}

	public CaveThread(CaveTest tcave, String name) {
		super();
		this.tcave = tcave;
		this.name = name;
	}

	@Override
	public void run() {
		tcave.PrintName(name);
	}

}
