package acer.allen.oop.interface1;

public class SuperMan implements Flyable,Sleepable {
	void saveEarth() {
		System.out.println("拯救地球");
	}

	@Override
	public void fly() {
		System.out.println("超人可以飞出地球！");

	}

	@Override
	public void sleep() {
		System.out.println("我一个月睡一次！");
		
	}

}
