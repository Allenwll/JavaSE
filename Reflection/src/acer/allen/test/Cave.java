package acer.allen.test;

public class Cave {
	/*
	 * 编写多线程程序，模拟多个人通过一个山洞的模拟。 这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
	 * 有10个人同时准备过此山洞，显示每次通过山洞人的姓名和顺序。
	 */

	String[] name = null;
	
	int index=0;

	public Cave() {

		String[] name = new String[] { "Allen", "Ruby", "Mars", "Mark", "Add", "Youre", "Zipper", "Hige", "Alg",
				"Alpha" };
		this.name = name;
	}

	public static void main(String[] args) {
		// 实例化
		Cave c = new Cave();
		c.sendName();
	}

	/**
	 * 给线程分配名字
	 */
	public void sendName() {
		for (int i = 0; i < name.length; i++) {
			CaveThread cave = new CaveThread(this, name[i]);
			cave.start();
		}

	}
	synchronized void printName(String name){
		index++;
		System.out.println(name+"-----------------------第"+index+"个通过山洞！");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(index==11){
			System.out.println("全部通过！");
		}
	}
}

class CaveThread extends Thread {

	Cave cave = null;
	String name;

	public CaveThread(Cave cave, String name) {
		this.cave = cave;
		this.name = name;
	}

	@Override
	public void run() {
		cave.printName(name);
	}
}
