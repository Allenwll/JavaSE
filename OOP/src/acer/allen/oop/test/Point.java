package acer.allen.oop.test;

public class Point {
	// x������
	private int x;
	// y������
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

	// ��ӡ����
	void print() {
		System.out.println("x������Ϊ:" + x + "\ny������Ϊ��" + y);
	}
}
