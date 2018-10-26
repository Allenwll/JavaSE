package acer.allen.oop.interface1;

public class Bird extends Animal implements Flyable, Sleepable {

	@Override
	public void fly() {
		System.out.println("鸟儿飞的一般般。");

	}

	@Override
	public void sleep() {
		System.out.println("我三小时睡一次。");

	}

	@Override
	void eat() {
		System.out.println("早起的鸟儿捉虫多");
		
	}

}
