package drink;

/**
 * ¿ÉÀÖ
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
		System.out.println("Ãû³Æ:" + super.getName() + "\nÈİÁ¿:" + super.getVolume());
	}

}
