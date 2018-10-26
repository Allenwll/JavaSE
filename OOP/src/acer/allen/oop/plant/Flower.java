package acer.allen.oop.plant;

/**
 * 花
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

	// 颜色
	private String color;
	// 花瓣的个数
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
		System.out.println("花朵生长...");
		this.setHeight(this.getHeight()+1);
	}

	@Override
	public void die() {
		System.out.println("=============================");
		System.out.println("花朵死亡...");
	}

	public String toString() {
		return super.toString()+ "\nColor(颜色:):" + color
				+ "\nPetalNum(花瓣个数:):" + petalNum;
	}
}
