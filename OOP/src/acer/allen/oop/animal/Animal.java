package acer.allen.oop.animal;

public class Animal {
	// ����
	public String name;
	// ����
	public int age = 0;
	// �Ա�
	public String sex;
	// ������
	public static int count;
	/*
	 * ��Ĵ���� { age = 23; System.out.println("��Ĵ���飡"); } static { count = 1;
	 * System.out.println("��ľ�̬����飡"); }
	 */

	// �޲ι���
	public Animal() {

		// age = 45; System.out.println("��Ĺ��췽��");

	}

	// �вι���
	public Animal(int age, String name) {
		this("��", age, name);
	}

	// �вι���
	public Animal(String sex, int age, String name) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	// ˯��
	public void sleep() {
		System.out.println("My name is " + name + ",I like make dream !");
	}

	// �Է�
	public void eat() {
		System.out.println("My hobby is eat food !");
	}

	// ��ʾ
	public void show() {
		System.out.println("\tInfo��\n" + "Name��" + name + "\nAge:" + age + "\nSex:" + sex);
		sleep();
		eat();
	}

	// ��̬����
	public static int getCount() {
		return count;
	}

	public static void main(String[] args) {
		// ����

		int len = (int) (Math.random() * 40) + 60;
		Animal[] a = new Animal[len];
		for (int i = 0; i < len; i++) { // ʵ����
			a[i] = new Animal();
			Animal.count++;
		} // ��ӡ //
		System.out.println("һ��������" + Animal.count + "������");
		System.out.println("һ��������" + Animal.getCount() + "������");
		Animal an = new Animal();
		System.out.println(an.age);
		an = new Animal();

	}
}
