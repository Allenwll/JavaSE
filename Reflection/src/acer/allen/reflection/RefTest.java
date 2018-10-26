package acer.allen.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ����
 * 
 * @author acer
 *
 */
public class RefTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {

		System.out.println("int�Ƿ��ǻ�������:" + int.class.isPrimitive());

		System.out.println("boolean�Ƿ��ǻ�������:" + boolean.class.isPrimitive());

		System.out.println("int[]�Ƿ��ǻ�������:" + int[].class.isPrimitive());

		System.out.println("void�Ƿ��ǻ������ͣ�" + void.class.isPrimitive());

		System.out.println(Integer.TYPE == int.class);

		Class c = Student.class;

		/***************************** ����Class������ **********************************/

		Field[] fields = c.getFields();

		// �õ������ı�.���÷����õ��ֶ�
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("------------------------");

		fields = c.getDeclaredFields();

		// �õ���������г�Ա
		for (Field field : fields) {
			System.out.println(field);
		}

		System.out.println("------------------------");

		// �õ���ǰ���ֱ�Ӹ�������г�Ա
		fields = c.getSuperclass().getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field);
		}

		/*******************************
		 * �޸�Class ������
		 **********************************/

		Field svalue = c.getField("svalue");
		// ��̬�Ĵ�null
		svalue.setInt(null, 100);

		System.out.println(svalue.getInt(null));

		Field age = c.getField("age");
		Student stu = new Student();
		age.setInt(stu, 10);
		System.out.println(age.getInt(stu));
		// ��Ҫ�����޸ĳ�Ա�ķ���Ȩ�ޣ������һϵ��bug
		Field sGender = c.getDeclaredField("sgender");
		// sGender.setAccessible(true);
		sGender.setChar(stu, 'Ů');
		System.out.println(sGender.getChar(stu));

		/**************************
		 * ������ĳ�Ա���� ʹ��Method��
		 ********************************/
		System.out.println("----------------����----------------");
		Method[] methods = c.getMethods();

		// �õ����еĹ��е� �����̳е�
		for (Method method : methods) {
			System.out.println(method);
		}

		methods = c.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		Method m;
		// ���÷���������޲Σ���null
		// Method m = c.getMethod("show", null);
		// m.invoke(null, null);

		// ���÷Ǿ�̬����n
		m = c.getDeclaredMethod("test", int.class);
		m.setAccessible(true);
		m.invoke(stu, 100);

		System.out.println("----------------���췽��----------------");
		/****************************** ���췽�� *************************************/

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
		System.out.println("����Student �޲ι��췽��");
	}

	public Student(int age) {
		System.out.println("����Student �вι��췽��----" + age);
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
