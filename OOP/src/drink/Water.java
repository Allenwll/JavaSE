package drink;

/**
 * 矿泉水
 * 
 * @author acer
 *
 */
public class Water extends Drink {

	
	public Water() {
		super.setName("矿泉水");
	}

	@Override
	public void show() {
		System.out.println("名称:" + super.getName() + "\n容量:" + super.getVolume());
	}

}
