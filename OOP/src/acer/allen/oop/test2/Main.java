package acer.allen.oop.test2;

public class Main {

	public static void main(String[] args) {
		Animal an = new Dog();
		System.out.println("ƒÍ¡‰:" + an.getAge());
		animalCry(new Dog());
		animalCry(new Cat());
		Dog dog = (Dog) an;
		dog.gnawBone();
		System.out.println(dog instanceof Animal);
		System.out.println(an instanceof Cat);
		System.out.println(an instanceof Dog);
			
	}

	static void animalCry(Animal a) {
		a.shout();
	}
}
