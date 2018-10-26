package acer.allen.oop.test2;

public class TestMain {

	public static void main(String[] args) {
		Dog d = new Dog("JiMi", 7, "Male", "ÄÁÑòÈ®", 1.2f, 1.0f, "°×É«");
		d.show();
		d.gnawBone();
		d.shout();
		System.out.println(d.toString() + "\n");
		Dog d1 = new Dog("JiMi", 7, "Male", "ÄÁÑòÈ®", 1.2f, 1.0f, "°×É«");
		System.out.println(d.equals(d1));
		Cat c = new Cat("¶¹½¬", 3, "Female", "åßÂÞÃ¨", 0.6f, 0.3f, "ºÚÉ«");
		c.show();
		c.toString();
		c.eatFish();
		c.shout();
		System.out.println(c.toString() + "\n");
		Fish f = new Fish("»¨¶ä", 1, "Female", "ÀðÓã", 0.1f, 0.1f, "ÒøÉ«");
		f.bubbling();
		System.out.println(f.toString());
	}

}
