package acer.allen.oop.constructor;

public class Student {
	// ID
	private int id;
	// ����
	private String name;
	// �Ա�
	private char sex;
	// ����
	private int age;
	// ��ַ
	private String address;

	// �޲ι��캯��
	public Student() {
		id = 2016001;
		name = "Mars";
		sex = '��';
		age=20;
		address = "���»�԰";
	}

	// ���캯������
	public Student(int id, String name, char sex, int age, String address) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	// ˯������
	void sleep() {
		System.out.println("���紺�μ���ʱ��ȥ�Ƴ������ٴ���");
	}

	// ѧϰ����
	void study() {
		System.out.println("��������ǧ���ڣ�");
	}

	void show() {
		System.out
				.println("ѧ����ϢΪ:\n" + "ѧ�ţ�" + id + "\n����:" + name + "\n�Ա�" + sex + "\n���䣺" + age + "\n��ַ��" + address);
	}
}
