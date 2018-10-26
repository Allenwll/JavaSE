package acer.allen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 测试
 * 
 * @author acer
 *
 */
public class RefTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {

		System.out.println("int是否是基本类型:" + int.class.isPrimitive());

		System.out.println("boolean是否是基本类型:" + boolean.class.isPrimitive());

		System.out.println("int[]是否是基本类型:" + int[].class.isPrimitive());

		System.out.println("void是否是基本类型：" + void.class.isPrimitive());

		System.out.println(Integer.TYPE == int.class);

		Class c = Student.class;

		/***************************** 访问Class的属性 **********************************/

		Field[] fields = c.getFields();

		// 得到公共的被.引用符引用的字段
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("------------------------");

		fields = c.getDeclaredFields();

		// 得到本类的所有成员
		for (Field field : fields) {
			System.out.println(field);
		}

		System.out.println("------------------------");

		// 得到当前类的直接父类的所有成员
		fields = c.getSuperclass().getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field);
		}

		/*******************************
		 * 修改Class 的属性
		 **********************************/

		Field svalue = c.getField("svalue");
		// 静态的传null
		svalue.setInt(null, 100);

		System.out.println(svalue.getInt(null));

		Field age = c.getField("age");
		Student stu = new Student();
		age.setInt(stu, 10);
		System.out.println(age.getInt(stu));
		// 不要尝试修改成员的访问权限，会出现一系列bug
		Field sGender = c.getDeclaredField("sgender");
		// sGender.setAccessible(true);
		sGender.setChar(stu, '女');
		System.out.println(sGender.getChar(stu));

		/**************************
		 * 访问类的成员方法 使用Method类
		 ********************************/
		System.out.println("----------------方法----------------");
		Method[] methods = c.getMethods();

		// 得到所有的公有的 包括继承的
		for (Method method : methods) {
			System.out.println(method);
		}

		methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		Method m;
		// 调用方法，如果无参，传null
		// Method m = c.getMethod("show", null);
		// m.invoke(null, null);

		// 调用非静态方法n
		m = c.getDeclaredMethod("test", int.class);
		m.setAccessible(true);
		m.invoke(stu, 100);

		System.out.println("----------------构造方法----------------");
		/****************************** 构造方法 *************************************/

		Constructor[] ct = c.getConstructors();
		for (Constructor constructor : ct) {
			System.out.println(constructor);
		}

		/*
		 * Constructor con = c.getConstructor(int.class); Person p = (Person)
		 * con.newInstance(12); System.out.println(p);
		 */

	}

}

class Student extends Person {

	public static int svalue;

	static char sgender;

	@SuppressWarnings("unused")
	private int sage;

	public String sname;

	boolean sflag;

	public int age;

	protected float height;

	public Student() {
		System.out.println("我是Student 无参构造方法");
	}

	public Student(int age) {
		System.out.println("我是Student 有参构造方法----" + age);
	}

	public static void show() {
		System.out.println("Student staic void show");
	}

	@SuppressWarnings("unused")
	private void test(int age) {
		System.out.println("Student-------test" + age);
	}

	protected void test1() {
		System.out.println("person-------test1");
	}

}
