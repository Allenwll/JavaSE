package acer.allen.oop.mon;

public class Monster {
	// 怪物名字
	private String name;
	// 生命值
	private int health;
	// 攻击力
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

	// 攻击方法
	public void attack() {
	}

	// 移动
	public void move() {

	}

}
