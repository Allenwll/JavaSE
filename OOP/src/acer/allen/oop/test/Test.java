package acer.allen.oop.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 类的实例化
		Point p = new Point();
		// 赋值x
		p.setX(56);
		// 赋值y
		p.setY(69);
		// 调用打印方法
		p.print();
		// 调用交换方法
		change(p);
		// Test t=new Test();
		// t.exchange(p);
		// 调用打印方法
		p.print();
	}

	// 调用方法
	static void change(Point p) {
		int x = p.getX();
		int y = p.getY();
		p.setX(y);
		p.setY(x);
	}

	void exchange(Point p) {
		int x = p.getX();
		int y = p.getY();
		p.setX(y);
		p.setY(x);
	}
}
