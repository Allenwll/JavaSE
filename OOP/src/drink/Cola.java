package drink;

/**
 * ����
 * 
 * @author acer
 *
 */
public class Cola extends Drink {

	

	public Cola() {
		super.setName(TestMain.myName);
	}

	@Override
	public void show() {
		System.out.println("����:" + super.getName() + "\n����:" + super.getVolume());
	}

}
