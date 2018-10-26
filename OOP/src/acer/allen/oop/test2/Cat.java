package acer.allen.oop.test2;

/**
 * 
 * @author Allen
 *
 */
public class Cat extends Animal {

	public Cat() {
	}

	public Cat(String name, int age, String sex, String breed, float height, float weight, String color) {
		super(name, age, sex, breed, height, weight, color);

	}

	@Override 
	// 注解 代表当前的方法是重写的父类的某个方法 ，如果父类中不存在该方法，编译不能通过
	public void shout() {
		System.out.println("喵`````````````````！");
	}

	public void eatFish() {
		System.out.println("我是吃鱼的专家！");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (this == obj) // 同一个对象作比较
			return true;

		if (obj instanceof Cat) {
			Cat cat = (Cat) obj;
			if (this.getAge() == cat.getAge() && this.getBreed().equals(cat.getBreed())
					&& this.getColor().equals(cat.getColor()) && this.getHeight() == cat.getHeight()
					&& this.getWeight() == this.getWeight() && this.getName().equals(cat.getName())
					&& this.getSex().equals(cat.getSex())) {
				return true;
			} else
				return false;

		} else
			return false;

	}

}
