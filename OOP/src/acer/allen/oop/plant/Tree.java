package acer.allen.oop.plant;

/**
 * 树
 * 
 * @author acer
 *
 */
public class Tree extends Plant {
	public Tree(String name, double height, int treeAge, double diameter) {
		super(name, height);
		this.treeAge = treeAge;
		this.diameter = diameter;

	}

	// 树龄
	private int treeAge;
	// 树干直径
	private double diameter;

	public int getTreeAge() {
		return treeAge;
	}

	public void setTreeAge(int treeAge) {
		this.treeAge = treeAge;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public void grow() {
		System.out.println("=============================");
		System.out.println("大树生长...");
		this.setHeight(this.getHeight()+1);
	}

	@Override
	public void die() {
		System.out.println("=============================");
		System.out.println("大树死亡...");
	}

	public String toString() {
		return super.toString()+ "\nTreeAge(树龄):" + treeAge + "\nDiameter(树干直径):"
				+ diameter;
	}
}
