package acer.allen.oop.polymorphism;

public class Tiger extends Animal {
	void eat() {
		System.out.println("Eat————Tiger");
	}

	void death(Animal a) {
		System.out.println("Die——————Tiger");
	}
	public void eat(Animal a){
		this.show();
		a.death(this);
	}
	@Override
	void show() {
		System.out.println("我是Tiger,就是我把你给吃了！");
	}
	
}
