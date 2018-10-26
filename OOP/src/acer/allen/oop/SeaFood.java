package acer.allen.oop;

/**
 * 海鲜比萨
 * 
 * @author acer
 *
 */
public class SeaFood extends Pizza {
	// 配料
	private String dosing;

	public SeaFood(int size, int price, String dosing) {
		super(size, price);
		super.setName("海鲜披萨");
		this.dosing = dosing;
	}

	@Override
	public void show() {
		System.out.println("名称:" + super.getName() + "\n价格:" + super.getPrice() + "元\n大小:" + super.getSize() + "寸\n配料:"
				+ this.dosing);

	}

}
