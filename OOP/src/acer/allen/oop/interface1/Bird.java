package acer.allen.oop.interface1;

public class Bird extends Animal implements Flyable, Sleepable {

	@Override
	public void fly() {
		System.out.println("����ɵ�һ��㡣");

	}

	@Override
	public void sleep() {
		System.out.println("����Сʱ˯һ�Ρ�");

	}

	@Override
	void eat() {
		System.out.println("��������׽���");
		
	}

}
