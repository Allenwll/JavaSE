package acer.allen.oop.mon;

/**
 * 蛇精类
 *
 * @author acer
 *
 */

public class Snake extends Monster {
	public Snake(String name, int health, int attackForce) {
		super(name, health, attackForce);
	}

	@Override // 攻击
	public void attack() {
		System.out.println("怪物蛇妖"+super.getName()+"展开攻击");
		System.out.println("当前生命值是:" + super.getHealth() + "\n攻击力是:" + super.getAttackForce());
	}

	// 补血
	public void addBlood() {
		System.out.print("实施大蛇补血术。。。。。。。");
		if (super.getHealth() < 10)
			super.setHealth(super.getHealth() + 20);
		else
			System.out.println("血量充足，尚不需要加血。");
		System.out.println("当前血量是:" + super.getHealth());

	}

	@Override // 移动
	public void move() {
		System.out.println("我是蛇怪，我走S型路线。");
	}

}
