package drink;

/**
 * ����
 * 
 * @author acer
 *
 */
public class Coffee extends Drink {
	// ����
	private String dosing;

	public String getDosing() {
		return dosing;
	}

	public void setDosing(String dosing) {
		this.dosing = dosing;
	}

	public Coffee() {
		super.setName("����");
		this.dosing=TestMain.dosing;
	}

	@Override
	public void show() {
		System.out.println("����:" + super.getName() + "\n����:" + super.getVolume() + "\n�������:" + dosing);
	}

}
