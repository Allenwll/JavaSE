package acer.allen.oop.test;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointOne p = new PointOne();
		System.out.println("第一点坐标为:("+p.x+","+p.y+")");
		PointOne p1=new PointOne();
		System.out.println("第二点坐标为:("+p1.x+","+p1.y+")");
		int x=p.x-p1.x;
		int y=p.y-p1.y;
		int result=(int)Math.sqrt((x*x)+(y*y));
		System.out.println("两点之间的距离为:"+Math.abs(result));
	}

}

class PointOne {
	// 定义x轴
	int x;
	// 定义y轴
	int y;

	public PointOne() {
		this.x = (int) (Math.random() * 30) + 30;
		this.y = (int) (Math.random() * 30) + 30;
	}
	
}
