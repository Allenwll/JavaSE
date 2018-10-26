package people;

public class Restaurant {

	public static void main(String[] args) {
		dinnerStyle(new Chinese());
		dinnerStyle(new Japanese());
		Chinese c = new Chinese(18, "Ğ¡Óê");
		Chinese c1 = new Chinese(18, "Ğ¡ÏÄ");
		System.out.println(c.equals(c1));
	}

	public static void dinnerStyle(Person p) {
		p.eat();
	}
}
