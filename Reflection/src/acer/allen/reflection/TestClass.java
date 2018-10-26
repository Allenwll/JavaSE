package acer.allen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestClass {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Class c = Fish.class;

		// 得到全路径名
		System.out.println("全路径名:" + c.getName());
		// 得到类名
		System.out.println("类名:" + c.getSimpleName());
		// 得到直接父类
		System.out.println("直接父类:" + c.getSuperclass());
		// 是否是接口
		System.out.println("是否是接口:" + c.isInterface());
		// 权限修饰符
		System.out.println("访问修饰符:" + Modifier.toString(TestClass.class.getModifiers()));

		System.err.println("\n--------------------------\n");
		// 非public不显示成员
		Field[] fields = c.getFields();
		for (Field field : fields) {
			System.out.println("成员权限：" + Modifier.toString(field.getModifiers()));
			System.out.println("类型:" + field.getType());
			System.out.println("名字:" + field.getName());
			System.out.println();
		}
		// 所有的都显示
		System.err.println("\n--------------------------\n");
		fields = c.getDeclaredFields();
		for (Field field : fields) {
			System.out.println("成员权限：" + Modifier.toString(field.getModifiers()));
			System.out.println("类型:" + field.getType());
			System.out.println("名字:" + field.getName());
			System.out.println();
		}

		// 获取构造方法
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

	char gender = '女';

	public Fish() {
		System.out.println("I'm a fish");
	}

	void show() {
		System.out.println("Hello everyone");
	}
}