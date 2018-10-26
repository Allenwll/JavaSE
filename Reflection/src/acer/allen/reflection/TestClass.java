package acer.allen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestClass {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Class c = Fish.class;

		// �õ�ȫ·����
		System.out.println("ȫ·����:" + c.getName());
		// �õ�����
		System.out.println("����:" + c.getSimpleName());
		// �õ�ֱ�Ӹ���
		System.out.println("ֱ�Ӹ���:" + c.getSuperclass());
		// �Ƿ��ǽӿ�
		System.out.println("�Ƿ��ǽӿ�:" + c.isInterface());
		// Ȩ�����η�
		System.out.println("�������η�:" + Modifier.toString(TestClass.class.getModifiers()));

		System.err.println("\n--------------------------\n");
		// ��public����ʾ��Ա
		Field[] fields = c.getFields();
		for (Field field : fields) {
			System.out.println("��ԱȨ�ޣ�" + Modifier.toString(field.getModifiers()));
			System.out.println("����:" + field.getType());
			System.out.println("����:" + field.getName());
			System.out.println();
		}
		// ���еĶ���ʾ
		System.err.println("\n--------------------------\n");
		fields = c.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("��ԱȨ�ޣ�" + Modifier.toString(field.getModifiers()));
			System.out.println("����:" + field.getType());
			System.out.println("����:" + field.getName());
			System.out.println();
		}

		// ��ȡ���췽��
		System.err.println("\n--------------------------\n");
		Constructor[] constructor = c.getConstructors();
		for (Constructor con : constructor) {
			System.out.println(con);
		}
	}
}

class Fish {

	public int[] friends = new int[10];

	public int age = 2;

	protected String name = "RedFish";

	char gender = 'Ů';

	public Fish() {
		System.out.println("I'm a fish");
	}

	void show() {
		System.out.println("Hello everyone");
	}
}