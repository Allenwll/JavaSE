package acer.allen.oop.constructor;

public class Student {
	// ID
	private int id;
	// 姓名
	private String name;
	// 性别
	private char sex;
	// 年龄
	private int age;
	// 地址
	private String address;

	// 无参构造函数
	public Student() {
		id = 2016001;
		name = "Mars";
		sex = '男';
		age=20;
		address = "育新花园";
	}

	// 构造函数重载
	public Student(int id, String name, char sex, int age, String address) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	// 睡觉方法
	void sleep() {
		System.out.println("来如春梦几多时，去似朝云无觅处！");
	}

	// 学习方法
	void study() {
		System.out.println("书中自有千钟粟！");
	}

	void show() {
		System.out
				.println("学生信息为:\n" + "学号：" + id + "\n姓名:" + name + "\n性别：" + sex + "\n年龄：" + age + "\n地址：" + address);
	}
}
