package people;

public class Japanese extends Person {
	public Japanese(int age, String name) {
		super(age, name);
	}

	@Override
	void show() {
		System.out.println("I'm a Janpanese ");
	}

	public Japanese() {
		// TODO Auto-generated constructor stub
	}

	public void eat() {
		this.show();
		System.out.println("Use knives and forks eat food !");
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		else
			return false;
	}
}
