package acer.allen.oop.mon;

public class Monster {
	// ��������
	private String name;
	// ����ֵ
	private int health;
	// ������
	private int attackForce;

	public Monster(String name, int health, int attackForce) {
		this.name = name;
		this.health = health;
		this.attackForce = attackForce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackForce() {
		return attackForce;
	}

	public void setAttackForce(int attackForce) {
		this.attackForce = attackForce;
	}

	// ��������
	public void attack() {
	}

	// �ƶ�
	public void move() {

	}

}
