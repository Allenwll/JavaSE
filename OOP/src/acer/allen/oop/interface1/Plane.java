package acer.allen.oop.interface1;

public class Plane implements Flyable,Sleepable{
	void takeGood(){
		System.out.println("���˷ɻ���");
	}

	@Override
	public void fly() {
		System.out.println("�ɻ��ɵĸ���!");
		
	}

	@Override
	public void sleep() {
		System.out.println("��һ��˯һ�Σ�");
		
	}

	
}
