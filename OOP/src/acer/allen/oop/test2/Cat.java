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
	// ע�� ����ǰ�ķ�������д�ĸ����ĳ������ ����������в����ڸ÷��������벻��ͨ��
	public void shout() {
		System.out.println("��`````````````````��");
	}

	public void eatFish() {
		System.out.println("���ǳ����ר�ң�");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (this == obj) // ͬһ���������Ƚ�
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
