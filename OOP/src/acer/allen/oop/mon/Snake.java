package acer.allen.oop.mon;

/**
 * �߾���
 *
 * @author acer
 *
 */

public class Snake extends Monster {
	public Snake(String name, int health, int attackForce) {
		super(name, health, attackForce);
	}

	@Override // ����
	public void attack() {
		System.out.println("��������"+super.getName()+"չ������");
		System.out.println("��ǰ����ֵ��:" + super.getHealth() + "\n��������:" + super.getAttackForce());
	}

	// ��Ѫ
	public void addBlood() {
		System.out.print("ʵʩ���߲�Ѫ����������������");
		if (super.getHealth() < 10)
			super.setHealth(super.getHealth() + 20);
		else
			System.out.println("Ѫ�����㣬�в���Ҫ��Ѫ��");
		System.out.println("��ǰѪ����:" + super.getHealth());

	}

	@Override // �ƶ�
	public void move() {
		System.out.println("�����߹֣�����S��·�ߡ�");
	}

}
