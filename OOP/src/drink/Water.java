package drink;

/**
 * ��Ȫˮ
 * 
 * @author acer
 *
 */
public class Water extends Drink {

	
	public Water() {
		super.setName("��Ȫˮ");
	}

	@Override
	public void show() {
		System.out.println("����:" + super.getName() + "\n����:" + super.getVolume());
	}

}
