package acer.allen.oop.polymorphism;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
			Tiger t=new Tiger();
			t.eat(new Dog());
			Animal a=new Tiger();
			Tiger t1=(Tiger)a;
			
	}
}
