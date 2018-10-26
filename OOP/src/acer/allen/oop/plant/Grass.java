package acer.allen.oop.plant;

/**
 * ��
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

	// �Ƿ��Ƕ�����
	private boolean perennation;
	// �Ƿ��ʳ
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
		System.out.println("С������...");
		this.setHeight(this.getHeight()+1);
	}
	

	@Override
	public void die() {
		System.out.println("=============================");
		System.out.println("С������...");
	}

	public String toString() {
		String str=(perennation)?"��":"��";
		String str1=(edible)?"��":"��";
		return super.toString()+ "\nPerennation(�Ƿ��Ƕ�����:):"
				+str+ "\nEdible(�Ƿ��ʳ:):" + str1;
	}
}
