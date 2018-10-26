package people;

public class Chinese extends Person {

	@Override
	void show() {
		System.out.println("I'm a Chinese ");
	}

	public void eat() {
		this.show();
		System.out.println("Use chopstick eat food !");
	}

	public Chinese(int age, String name) {
		super(age, name);
	}

	public Chinese() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		else
			return false;
	}

}
