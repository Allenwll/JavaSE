package car;

public class Vehicle {
	// 车型
	private String carType;
	// 车牌
	private String carNo;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	// 启动方法
	public void start() {
		System.out.println("我是车，我启动");
	}

	// 停止方法
	public void stop() {
		System.out.println("我是车，我停止");
	}

	// 到达方法
	public void arrive() {

	}
}
