package acer.allen.oop.work;


public class airCondition {
	String brand;
	int num;
	int temper;
	
	void warmUp(){
		temper+=10;
		System.out.println("���ѿ������ȹ��ܣ�");
	}
	void refrigeration(){
		temper-=10;
		System.out.println("���ѿ������书�ܣ�");
	}
	void ventilation(){
		System.out.println("���ѿ���ͨ�繦�ܣ�");
	}
	public airCondition(String brand,int num,int temper) {
		this.brand=brand;
		this.num=num;
		this.temper=temper;
	}
	void show(){
		System.out.println(brand+"�ƿյ���ƥ����"+num+",�¶�������"+temper+"��");
	}
	public static void main(String[] args) {
		airCondition a=new airCondition("����", 98, 20);
		a.show();
		a.warmUp();
		a.refrigeration();
		a.ventilation();
	}
}
