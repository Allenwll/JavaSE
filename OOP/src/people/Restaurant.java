package people;

public class Restaurant {

	public static void main(String[] args) {
		dinnerStyle(new Chinese());
		dinnerStyle(new Japanese());
		Chinese c = new Chinese(18, "С��");
		Chinese c1 = new Chinese(18, "С��");
		System.out.println(c.equals(c1));
	}

	public static void dinnerStyle(Person p) {
		p.eat();
	}
}
