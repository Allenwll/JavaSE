package acer.allen.oop.mon;

public class Test {
	public static void main(String[] args) {
		Snake s=new Snake("Ð¡°×", 5, 20);
		s.attack();
		s.addBlood();
		s.move();
		System.out.println("======================");
		Scolopendra sc=new Scolopendra("Ð¡ºÚ", 60, 15);
		sc.attack();
		sc.move();
	}

}
