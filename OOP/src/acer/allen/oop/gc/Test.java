package acer.allen.oop.gc;

public class Test {

	public static void main(String[] args) {
		Animal an = new Animal("A");
		Animal an2 = new Animal("B");
		Animal an3 = new Animal("C");
		an2.destory();
		an2 = null;
		an3.destory();
		an3 = null;
		an.destory();
		an = null;
		Thread.yield(); //��ͣ���߳� ִ�������߳�
		System.gc();
	}

}
