package acer.allen.oop;

/**
 * ���ʱ���
 * 
 * @author acer
 *
 */
public class SeaFood extends Pizza {
	// ����
	private String dosing;

	public SeaFood(int size, int price, String dosing) {
		super(size, price);
		super.setName("��������");
		this.dosing = dosing;
	}

	@Override
	public void show() {
		System.out.println("����:" + super.getName() + "\n�۸�:" + super.getPrice() + "Ԫ\n��С:" + super.getSize() + "��\n����:"
				+ this.dosing);

	}

}
