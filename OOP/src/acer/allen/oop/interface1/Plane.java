package acer.allen.oop.interface1;

public class Plane implements Flyable,Sleepable{
	void takeGood(){
		System.out.println("货运飞机！");
	}

	@Override
	public void fly() {
		System.out.println("飞机飞的更高!");
		
	}

	@Override
	public void sleep() {
		System.out.println("我一周睡一次！");
		
	}

	
}
