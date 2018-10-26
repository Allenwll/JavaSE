package acer.allen.test;

public class Cave {
	/*
	 * ��д���̳߳���ģ������ͨ��һ��ɽ����ģ�⡣ ���ɽ��ÿ��ֻ��ͨ��һ���ˣ�ÿ����ͨ��ɽ����ʱ��Ϊ5�룬
	 * ��10����ͬʱ׼������ɽ������ʾÿ��ͨ��ɽ���˵�������˳��
	 */

	String[] name = null;
	
	int index=0;

	public Cave() {

		String[] name = new String[] { "Allen", "Ruby", "Mars", "Mark", "Add", "Youre", "Zipper", "Hige", "Alg",
				"Alpha" };
		this.name = name;
	}

	public static void main(String[] args) {
		// ʵ����
		Cave c = new Cave();
		c.sendName();
	}

	/**
	 * ���̷߳�������
	 */
	public void sendName() {
		for (int i = 0; i < name.length; i++) {
			CaveThread cave = new CaveThread(this, name[i]);
			cave.start();
		}

	}
	synchronized void printName(String name){
		index++;
		System.out.println(name+"-----------------------��"+index+"��ͨ��ɽ����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(index==11){
			System.out.println("ȫ��ͨ����");
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
