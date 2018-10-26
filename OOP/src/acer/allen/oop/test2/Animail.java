package acer.allen.oop.test2;

import java.util.Scanner;

import acer.allen.oop.animal.Animal;

public class Animail extends Animal {

	public Animail(int age, String name) {
		super(age, name);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("����������:");
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		System.out.println("����������:");
		String name = scan.next();
		Animail a = new Animail(age, name);
		a.sleep();
		a.eat();
		a.show();
	}
}
