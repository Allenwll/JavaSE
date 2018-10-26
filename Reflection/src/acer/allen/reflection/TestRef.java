package acer.allen.reflection;

/**
 * ���������
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

			// Java 8�ֻ����������� +void ���ַ�����Class����
			System.out.println("boolean����Class����:" + boolean.class + "\n");
			System.out.println("byte����Class����:" + byte.class + "\n");
			System.out.println("short����Class����:" + short.class + "\n");
			System.out.println("int����Class����:" + int.class + "\n");
			System.out.println("long����Class����:" + long.class + "\n");
			System.out.println("char����Class����:" + char.class + "\n");
			System.out.println("float����Class����:" + float.class + "\n");
			System.out.println("double����Class����:" + double.class + "\n");
			System.out.println("void���͵�Class����:" + void.class + "\n");
			System.out.println("string����Class����:" + String.class + "\n");

			int[] ints = new int[2];

			int[][] intss = new int[3][];

			// ���� ÿ������ ������ĳ��Class��Ķ��� ���о�����ͬ���ͺ�ά�ȵ����鹲��һ��Class �Ķ���
			System.out.println("intһά�����Class����:" + ints.getClass() + "\n");
			System.out.println("int��ά�����Class����:" + intss.getClass() + "\n");

			Dog[] d = new Dog[10];

			System.out.println("Dog������:" + d.getClass().hashCode());

		} else {

		}

	}

}

/**
 * ����ģʽ
 * 
 * ����ԭ��
 * 
 * �����ӿ���
 * 
 * ���޸Ĺر�
 * 
 * @author acer
 *
 */
class Factory {

	public static Object getInstance(String className)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		/*
		 * �����Ͽ���ԭ�� if (className.equals("Dog")) { return new Dog(); } else if
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