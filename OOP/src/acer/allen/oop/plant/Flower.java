package acer.allen.oop.plant;

/**
 * ��
 * 
 * @author acer
 *
 */
public class Flower extends Plant {
	public Flower(String name, double height, String color, int petalNum) {
		super(name, height);
		this.color = color;
		this.petalNum = petalNum;
	}

	// ��ɫ
	private String color;
	// ����ĸ���
	private int petalNum;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPetalNum() {
		return petalNum;
	}

	public void setPetalNum(int petalNum) {
		this.petalNum = petalNum;
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
		return super.toString()+ "\nColor(��ɫ:):" + color
				+ "\nPetalNum(�������:):" + petalNum;
	}
}
