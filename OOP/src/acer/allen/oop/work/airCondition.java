package acer.allen.oop.work;


public class airCondition {
	String brand;
	int num;
	int temper;
	
	void warmUp(){
		temper+=10;
		System.out.println("您已开启加热功能！");
	}
	void refrigeration(){
		temper-=10;
		System.out.println("您已开启制冷功能！");
	}
	void ventilation(){
		System.out.println("您已开启通风功能！");
	}
	public airCondition(String brand,int num,int temper) {
		this.brand=brand;
		this.num=num;
		this.temper=temper;
	}
	void show(){
		System.out.println(brand+"牌空调，匹数是"+num+",温度现在是"+temper+"度");
	}
	public static void main(String[] args) {
		airCondition a=new airCondition("格力", 98, 20);
		a.show();
		a.warmUp();
		a.refrigeration();
		a.ventilation();
	}
}
