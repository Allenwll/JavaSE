package drink;

public class DrickFactory {
	public static Drink getInstance(int num) {
		Drink d = null;
		switch (num) {
		case 1:
			d = new Coffee();
			break;
		case 2:
			d = new Water();
			break;
		case 3:
			d = new Cola();
			break;
		}
		return d;
	}
}
