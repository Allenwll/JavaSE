package thread.cave;

public class CaveTest {
	private String[] name;

	private int count = 1;

	public String[] getName() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	public CaveTest() {
		String[] name = { "Allen", "Mars", "Judy", "Any", "Sunny", "Bobi", "Mini", "Pink", "Yobu", "Zippes" };
		this.name = name;
	}

	void sendAllName() throws InterruptedException {
		for (int i = 0; i < name.length; i++) {
			CaveThread ct = new CaveThread(this, name[i]);
			ct.start();
		}	
	}

	public static void main(String[] args) throws InterruptedException {
		CaveTest c = new CaveTest();
		c.sendAllName();
		
	}

	public synchronized void printName(String name) throws InterruptedException {
		System.out.println(name + "------------------第" + count + "个通过山洞\n");
		count++;
		Thread.sleep(1000);
		for (int i = 5; i > 0; i--) {
			System.err.println(i);
			Thread.sleep(1000);
		}
		if(count==11){
			System.out.println("\n\t\t全部通过山洞！");
			System.exit(0);
		}
	}
}

class CaveThread extends Thread {
	CaveTest ct;
	String name;

	public CaveThread(CaveTest ct, String name) {
		this.ct = ct;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			ct.printName(name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}