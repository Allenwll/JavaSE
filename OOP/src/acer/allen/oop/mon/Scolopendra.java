package acer.allen.oop.mon;

/**
 * 蜈蚣精类
 * 
 * @author acer
 *
 */
public class Scolopendra extends Monster {

	public Scolopendra(String name, int health, int attackForce) {
		super(name, health, attackForce);
	}

	@Override // 攻击方法
	public void attack() {
		System.out.println("怪物蜈蚣精"+super.getName()+"展开攻击");
		System.out.println("当前生命值是:" + super.getHealth() + "\n攻击力是:" + super.getAttackForce());
	}

	@Override // 移动
	public void move() {
		System.out.println("我是蜈蚣精，御风飞行。");
	}
}
