package acer.allen.oop.plant;

public abstract class Plant {
	// ����
	private String name;
	// �߶�
	private double height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Plant() {
		System.out.println("I��m Plant.");
		grow();
		die();
	}

	public Plant(String name, double height) {
		this.name = name;
		this.height = height;
	}

	public abstract void grow();

	public abstract void die() ;
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Plant: Name(����):"+name+"\nHeight(�߶�):"+height;
	}

}
