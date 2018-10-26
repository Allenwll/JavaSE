package acer.allen;

public class Person {
	private Name name;
	private Gender gender;
	private int age;
	private int id;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Person(int id) {
		super();
		this.name = MyUtils.getRandomName();
		this.gender = MyUtils.getRandomGender();
		this.age = MyUtils.getNextInt(2) + 19;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + " **** gender=" + gender + " **** age=" + age + " ****  id=" + id + "]\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (gender != other.gender)
			return false;
		if (name != other.name)
			return false;
		return true;
	}
}
