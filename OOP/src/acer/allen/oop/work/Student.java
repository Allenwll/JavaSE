package acer.allen.oop.work;

public class Student {
	int sNo;
	String sName;
	String sSex;
	int sAge;
	int sJava;

	public Student(int sNo, String sName, String sSex, int sAge, int sJava) {
		this.sNo = sNo;
		this.sName = sName;
		this.sSex = sSex;
		this.sAge = sAge;
		this.sJava = sJava;
	}

	void getNo() {
		System.out.println("ѧ��Ϊ:" + sNo);
	}

	void getName() {
		System.out.println("����Ϊ:" + sName);
	}

	void getSex() {
		System.out.println("�Ա�Ϊ:" + sSex);
	}

	void getAge() {
		System.out.println("����Ϊ:" + sAge);
	}

	int getJava() {
		System.out.println("Java �ɼ�Ϊ" + sJava);
		return sJava;
	}

	void show() {
		getNo();
		getName();
		getSex();
		getAge();
		getJava();
	}

	public static void main(String[] args) {
		Student[] s = new Student[5];
		s[0] = new Student(001, "Mars", "��", 19, 56);
		s[0].show();
		s[1] = new Student(002, "MarK", "��", 20, 87);
		s[1].show();
		s[2] = new Student(003, "Mary", "Ů", 18, 99);
		s[2].show();
		s[3] = new Student(004, "Jerry", "��", 19, 30);
		s[3].show();
		s[4] = new Student(005, "shirley ", "Ů", 19, 89);
		s[4].show();
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += s[i].getJava();
		}
		System.out.println("ƽ��ֵΪ:" + (sum / 5));
		int min=0,max=0;
		min=max=s[0].getJava();
		int j=1;
		for (int i = 0; i < s.length-1; i++) {
			if(s[i].getJava()>s[j].getJava())
				max=s[i].getJava();
			else
				min=s[i].getJava();
			j++;
		}
		System.out.println("��СֵΪ:"+min+"\n���ֵΪ:"+max);
	}
}
