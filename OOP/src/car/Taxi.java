package car;

/**
 * ���⳵��
 * 
 * @author acer
 *
 */
public class Taxi extends Vehicle {
	// �������⹫˾
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
		System.out.println("�˿�����:\n����" + company + "�ģ��ҵĳ�����" + super.getCarNo() + ",��Ҫȥ����?");
	}

	// ����
	public void show() {
		System.out.println("Ŀ�ĵ��Ѿ����ˣ����������³�����ӭ�ٴγ�����");
	}

}
