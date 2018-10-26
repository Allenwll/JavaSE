package acer.allen.oop.test2;

public class Animal {
	private int age = 18;
	// 姓名
	private String name;
	// 性别
	private String sex;
	// 体重
	private float weight;
	// 身高
	private float height;
	// 品种
	private String breed;
	// 颜色
	protected String color;

	public Animal() {
	}

	public Animal(String name, int age, String sex, String breed, float height, float weight, String color) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.color = color;
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void shout() {

	}

	public void eat() {
		System.out.println("动物吃东西!");
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return getName() + "\t" + getSex() + "\t" + getAge() + "\t" + getBreed() + "\t" + getHeight() + "\t"
				+ getWeight() + "\t" + getColor();
	}

	public void show() {
		System.out.println("\t 信息");
		System.out.println("Name:" + name + "\nAge:" + age + "\nSex:" + sex + "\nWeight:" + weight + "\nHeight:"
				+ height + "\nBreed:" + breed);
	}

}
