package acer.allen.oop.test2;

public class TestMain {

	public static void main(String[] args) {
		Dog d = new Dog("JiMi", 7, "Male", "����Ȯ", 1.2f, 1.0f, "��ɫ");
		d.show();
		d.gnawBone();
		d.shout();
		System.out.println(d.toString() + "\n");
		Dog d1 = new Dog("JiMi", 7, "Male", "����Ȯ", 1.2f, 1.0f, "��ɫ");
		System.out.println(d.equals(d1));
		Cat c = new Cat("����", 3, "Female", "����è", 0.6f, 0.3f, "��ɫ");
		c.show();
		c.toString();
		c.eatFish();
		c.shout();
		System.out.println(c.toString() + "\n");
		Fish f = new Fish("����", 1, "Female", "����", 0.1f, 0.1f, "��ɫ");
		f.bubbling();
		System.out.println(f.toString());
	}

}
