package acer.allen.oop.polymorphism;

public class Cat extends Animal {
	void eat() {
		System.out.println("Eat��������Cat");
	}

	void death(Animal a) {
		System.out.println("Die������������Cat");
	}
	@Override
	void show() {
		System.out.println("����Cat,�����Ұ�������ˣ�");
	}
	
}
