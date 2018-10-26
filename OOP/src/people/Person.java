package people;

public class Person {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {

	}

	void show() {

	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int age, String name) {
		this.setAge(age);
		this.setName(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (this.name == null)
			return false;
		if (obj instanceof Person) {
			Person p = (Person) obj;
			if (this.age == p.age && this.name.equals(p.name))
				return true;
			else
				return false;
		} else
			return false;
	}
}
