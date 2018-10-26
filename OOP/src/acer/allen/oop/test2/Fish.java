package acer.allen.oop.test2;

public class Fish extends Animal {

	public Fish() {
	}

	public Fish(String name, int age, String sex, String breed, float height, float weight, String color) {
		super(name, age, sex, breed, height, weight, color);
	}

	@Override
	public String toString() {
		return getName() + "\t" + getSex() + "\t" + getColor() + "\t" + getBreed();
	}

	// 冒泡
	public void bubbling() {
		System.out.println("我的名字是" + getName() + "，我会吐泡泡");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (this == obj) // 同一个对象作比较
			return true;

		if (obj instanceof Fish) {
			Fish fish = (Fish) obj;
			if (this.getAge() == fish.getAge() && this.getBreed().equals(fish.getBreed())
					&& this.getColor().equals(fish.getColor()) && this.getHeight() == fish.getHeight()
					&& this.getWeight() == this.getWeight() && this.getName().equals(fish.getName())
					&& this.getSex().equals(fish.getSex())) {
				return true;
			} else
				return false;

		} else
			return false;

	}
}
