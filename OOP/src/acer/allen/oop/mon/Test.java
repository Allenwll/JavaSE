package acer.allen.oop.mon;

public class Test {
	public static void main(String[] args) {
		Snake s=new Snake("С��", 5, 20);
		s.attack();
		s.addBlood();
		s.move();
		System.out.println("======================");
		Scolopendra sc=new Scolopendra("С��", 60, 15);
		sc.attack();
		sc.move();
	}

}
