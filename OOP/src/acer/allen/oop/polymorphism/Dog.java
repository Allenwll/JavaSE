package acer.allen.oop.polymorphism;

public class Dog extends Animal {
	void eat() {
		System.out.println("Eat————Dog");
	}

	void death(Animal a) {
		System.out.println("Die——————dog");
	}
	@Override
	void show() {
		System.out.println("我是Dog，就是我把你给吃了！");
	}

}
