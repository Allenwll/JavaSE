package acer.allen.reflection;

/**
 * 反射测试类
 * 
 * @author acer
 *
 */
public class TestRef {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		int i = 0;

		if (i == 0) {

			Class<?> c = Class.forName("acer.allen.reflection.Dog");

			Dog dog = (Dog) c.newInstance();

			dog.show();

			// Java 8种基本数据类型 +void 和字符串的Class对象
			System.out.println("boolean类型Class对象:" + boolean.class + "\n");
			System.out.println("byte类型Class对象:" + byte.class + "\n");
			System.out.println("short类型Class对象:" + short.class + "\n");
			System.out.println("int类型Class对象:" + int.class + "\n");
			System.out.println("long类型Class对象:" + long.class + "\n");
			System.out.println("char类型Class对象:" + char.class + "\n");
			System.out.println("float类型Class对象:" + float.class + "\n");
			System.out.println("double类型Class对象:" + double.class + "\n");
			System.out.println("void类型的Class对象:" + void.class + "\n");
			System.out.println("string类型Class对象:" + String.class + "\n");

			int[] ints = new int[2];

			int[][] intss = new int[3][];

			// 数组 每个数组 都属于某个Class类的对象 所有具有相同类型和维度的数组共享一个Class 的对象
			System.out.println("int一维数组的Class对象:" + ints.getClass() + "\n");
			System.out.println("int二维数组的Class对象:" + intss.getClass() + "\n");

			Dog[] d = new Dog[10];

			System.out.println("Dog类数组:" + d.getClass().hashCode());

		} else {

		}

	}

}

/**
 * 工厂模式
 * 
 * 开闭原则
 * 
 * 对增加开放
 * 
 * 对修改关闭
 * 
 * @author acer
 *
 */
class Factory {

	public static Object getInstance(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*
		 * 不符合开闭原则 if (className.equals("Dog")) { return new Dog(); } else if
		 * (className.equals("Cat")) { return new Cat(); } return null;
		 */

		return Class.forName(className).newInstance();
	}

}

class Dog {
	static {
		System.err.println("I'm a SuperDog.");
	}

	void show() {
		System.out.println("------------------");
	}
}

class Cat {
	static {
		System.err.println("I am a white Cat.");
	}
}