package acer.allen.oop.mon;

/**
 * ��򼾫��
 * 
 * @author acer
 *
 */
public class Scolopendra extends Monster {

	public Scolopendra(String name, int health, int attackForce) {
		super(name, health, attackForce);
	}

	@Override // ��������
	public void attack() {
		System.out.println("������򼾫"+super.getName()+"չ������");
		System.out.println("��ǰ����ֵ��:" + super.getHealth() + "\n��������:" + super.getAttackForce());
	}

	@Override // �ƶ�
	public void move() {
		System.out.println("������򼾫��������С�");
	}
}
