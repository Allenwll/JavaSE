package acer.allen.oop.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ʵ����
		Point p = new Point();
		// ��ֵx
		p.setX(56);
		// ��ֵy
		p.setY(69);
		// ���ô�ӡ����
		p.print();
		// ���ý�������
		change(p);
		// Test t=new Test();
		// t.exchange(p);
		// ���ô�ӡ����
		p.print();
	}

	// ���÷���
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
