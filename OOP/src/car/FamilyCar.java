package car;

public class FamilyCar extends Vehicle {

	// ��������
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("====================================");
		System.out.println("����" + name + "���ҵ�����������!");
	}

	@Override
	public void arrive() {
		System.out.println("Ŀ�ĵص��ˣ�����ȥ���");
	}

}
