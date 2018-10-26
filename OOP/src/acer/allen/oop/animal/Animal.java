package acer.allen.oop.animal;

public class Animal {
	// 名字
	public String name;
	// 年龄
	public int age = 0;
	// 性别
	public String sex;
	// 计数器
	public static int count;
	/*
	 * 类的代码块 { age = 23; System.out.println("类的代码块！"); } static { count = 1;
	 * System.out.println("类的静态代码块！"); }
	 */

	// 无参构造
	public Animal() {

		// age = 45; System.out.println("类的构造方法");

	}

	// 有参构造
	public Animal(int age, String name) {
		this("男", age, name);
	}

	// 有参构造
	public Animal(String sex, int age, String name) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	// 睡觉
	public void sleep() {
		System.out.println("My name is " + name + ",I like make dream !");
	}

	// 吃饭
	public void eat() {
		System.out.println("My hobby is eat food !");
	}

	// 显示
	public void show() {
		System.out.println("\tInfo：\n" + "Name：" + name + "\nAge:" + age + "\nSex:" + sex);
		sleep();
		eat();
	}

	// 静态方法
	public static int getCount() {
		return count;
	}

	public static void main(String[] args) {
		// 声明

		int len = (int) (Math.random() * 40) + 60;
		Animal[] a = new Animal[len];
		for (int i = 0; i < len; i++) { // 实例化
			a[i] = new Animal();
			Animal.count++;
		} // 打印 //
		System.out.println("一共生成了" + Animal.count + "个对象！");
		System.out.println("一共生成了" + Animal.getCount() + "个对象！");
		Animal an = new Animal();
		System.out.println(an.age);
		an = new Animal();

	}
}
