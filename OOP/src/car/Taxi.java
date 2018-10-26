package car;

/**
 * 出租车类
 * 
 * @author acer
 *
 */
public class Taxi extends Vehicle {
	// 所属出租公司
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public void arrive() {
		System.out.println("====================================");
		System.out.println("乘客您好:\n我是" + company + "的，我的车牌是" + super.getCarNo() + ",您要去哪里?");
	}

	// 到达
	public void show() {
		System.out.println("目的地已经到了，请您付费下车，欢迎再次乘坐！");
	}

}
