package acer.allen.oop.interface1;

public class SuperMan implements Flyable,Sleepable {
	void saveEarth() {
		System.out.println("���ȵ���");
	}

	@Override
	public void fly() {
		System.out.println("���˿��Էɳ�����");

	}

	@Override
	public void sleep() {
		System.out.println("��һ����˯һ�Σ�");
		
	}

}
