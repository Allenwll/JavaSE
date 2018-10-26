package acer.allen.collection;

import java.util.Random;

import acer.allen.collection.list.Name;

public class Person {
	private Name name;
	private Gender sex;
	private int age;
	static Random random = new Random();

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		super();
		int ran = random.nextInt(2);
		if (ran == 0) {
			this.name = Name.A;
			this.sex = Gender.男;
		} else {
			this.name = Name.B;
			this.sex = Gender.女;
		}
		int r = random.nextInt(25);
		this.age = r;
	}
	@Override
	public String toString() {
		return "姓名："+this.getName()+"\t 年龄:"+this.getAge()+"\t 性别："+this.getSex();
	}

}
