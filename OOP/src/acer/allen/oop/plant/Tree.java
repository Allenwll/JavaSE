package acer.allen.oop.plant;

/**
 * ��
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

	// ����
	private int treeAge;
	// ����ֱ��
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
		System.out.println("��������...");
		this.setHeight(this.getHeight()+1);
	}

	@Override
	public void die() {
		System.out.println("=============================");
		System.out.println("��������...");
	}

	public String toString() {
		return super.toString()+ "\nTreeAge(����):" + treeAge + "\nDiameter(����ֱ��):"
				+ diameter;
	}
}
