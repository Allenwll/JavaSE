package acer.allen.oop.test2;

/**
 * @author acer
 */
public class Dog extends Animal {

	public Dog() {
	}

	public Dog(String name, int age, String sex, String breed, float height, float weight, String color) {
		super(name, age, sex, breed, height, weight, color);
	}

	@Override
	public void shout() {
		System.out.println("汪~~~~~~~~~~！");
	}

	public void gnawBone() {
		System.out.println("我在啃骨头");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + "\t" + getSex() + "\t" + getAge() + "\t" + getBreed() + "\t" + getHeight() + "\t"
				+ getWeight() + "\t" + getColor();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (this == obj) // 同一个对象作比较
			return true;

		if (obj instanceof Dog) {
			Dog dog = (Dog) obj;
			if (this.getAge() == dog.getAge() && this.getBreed().equals(dog.getBreed())
					&& this.getColor().equals(dog.getColor()) && this.getHeight() == dog.getHeight()
					&& this.getWeight() == this.getWeight() && this.getName().equals(dog.getName())
					&& this.getSex().equals(dog.getSex())) {
				return true;
			} else
				return false;

		} else
			return false;

	}

}
