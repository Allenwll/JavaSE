package car;

public class Vehicle {
	// ����
	private String carType;
	// ����
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

	// ��������
	public void start() {
		System.out.println("���ǳ���������");
	}

	// ֹͣ����
	public void stop() {
		System.out.println("���ǳ�����ֹͣ");
	}

	// ���﷽��
	public void arrive() {

	}
}
