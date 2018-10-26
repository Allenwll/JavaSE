package work;

public class Student {
	private int stuId;
	private String name;
	private int age;
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student(int stuId, String name, int age, String sex) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

}
