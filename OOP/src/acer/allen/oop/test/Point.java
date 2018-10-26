package acer.allen.oop.test;

public class Point {
	// x轴坐标
	private int x;
	// y轴坐标
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// 打印方法
	void print() {
		System.out.println("x轴坐标为:" + x + "\ny轴坐标为：" + y);
	}
}
