package acer.allen.oop.test;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointOne p = new PointOne();
		System.out.println("��һ������Ϊ:("+p.x+","+p.y+")");
		PointOne p1=new PointOne();
		System.out.println("�ڶ�������Ϊ:("+p1.x+","+p1.y+")");
		int x=p.x-p1.x;
		int y=p.y-p1.y;
		int result=(int)Math.sqrt((x*x)+(y*y));
		System.out.println("����֮��ľ���Ϊ:"+Math.abs(result));
	}

}

class PointOne {
	// ����x��
	int x;
	// ����y��
	int y;

	public PointOne() {
		this.x = (int) (Math.random() * 30) + 30;
		this.y = (int) (Math.random() * 30) + 30;
	}
	
}
