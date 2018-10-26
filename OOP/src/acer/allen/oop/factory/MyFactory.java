package acer.allen.oop.factory;

/**
 * 简单的工厂模式
 * 
 * @author acer
 *
 */
public class MyFactory {

	public static Animal getMyObj(String className) {
		Animal a = null;
		switch (className) {
		case "Animal":
			a = new Animal();
			break;
		case "Cat":
			a = new Cat();
			break;
		case "Dog":
			a = new Dog();
			break;
		}
		return a;
	}

}
