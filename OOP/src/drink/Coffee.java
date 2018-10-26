package drink;

/**
 * 咖啡
 * 
 * @author acer
 *
 */
public class Coffee extends Drink {
	// 配料
	private String dosing;

	public String getDosing() {
		return dosing;
	}

	public void setDosing(String dosing) {
		this.dosing = dosing;
	}

	public Coffee() {
		super.setName("咖啡");
		this.dosing=TestMain.dosing;
	}

	@Override
	public void show() {
		System.out.println("名称:" + super.getName() + "\n容量:" + super.getVolume() + "\n添加配料:" + dosing);
	}

}
