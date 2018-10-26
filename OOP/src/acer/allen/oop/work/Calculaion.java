package acer.allen.oop.work;

public class Calculaion {
	private int x;
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
	public Calculaion(int x,int y) {
		this.x=x;
		this.y=y;
	}
	void add(){
		System.out.println("两数相加为:"+(getX()+getY()));
	}
	
	void sub(){
		System.out.println("两数相减为:"+(getX()-getY()));
	}
	
	void times(){
		System.out.println("两数相乘为:"+getX()*getY());
	}
	
	void div(){
		System.out.println("两数相加除:"+getX()/getY());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculaion c=new Calculaion(6, 3);
		c.add();
		c.sub();
		c.times();
		c.div();
		

	}

}
