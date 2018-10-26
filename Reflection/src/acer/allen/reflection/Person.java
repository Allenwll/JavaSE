package acer.allen.reflection;

public class Person {

	public static int pvalue;

	static char pgender;

	@SuppressWarnings("unused")
	private int page;

	public String pname;

	boolean pflag;

	protected float height;

	public Person() {
		System.out.println("我是Person 无参构造方法");
	}

	public Person(int age) {
		System.out.println("我是Person 有参构造方法----" + age);
	}

	public static void show() {
		System.out.println("person staic void show");
	}

	@SuppressWarnings("unused")
	private void test() {
		System.out.println("person-------test");
	}

	protected void test1() {
		System.out.println("person-------test1");
	}

}
