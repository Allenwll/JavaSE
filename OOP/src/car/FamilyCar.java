package car;

public class FamilyCar extends Vehicle {

	// 车主姓名
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("====================================");
		System.out.println("我是" + name + "，我的汽车我做主!");
	}

	@Override
	public void arrive() {
		System.out.println("目的地到了，我们去玩吧");
	}

}
