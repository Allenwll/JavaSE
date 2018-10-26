package acer.allen.oop.plant;

/**
 * 草
 * 
 * @author acer
 *
 */
public class Grass extends Plant {
	public Grass(String name, double height,boolean perennation,boolean edible) {
		super(name, height);
		this.perennation=perennation;
		this.edible=edible;
	}

	// 是否是多年生
	private boolean perennation;
	// 是否可食
	private boolean edible;

	public boolean isPerennation() {
		return perennation;
	}

	public void setPerennation(boolean perennation) {
		this.perennation = perennation;
	}

	public boolean isEdible() {
		return edible;
	}

	public void setEdible(boolean edible) {
		this.edible = edible;
	}

	@Override
	public void grow() {
		System.out.println("=============================");
		System.out.println("小草生长...");
		this.setHeight(this.getHeight()+1);
	}
	

	@Override
	public void die() {
		System.out.println("=============================");
		System.out.println("小草死亡...");
	}

	public String toString() {
		String str=(perennation)?"是":"否";
		String str1=(edible)?"是":"否";
		return super.toString()+ "\nPerennation(是否是多年生:):"
				+str+ "\nEdible(是否可食:):" + str1;
	}
}
