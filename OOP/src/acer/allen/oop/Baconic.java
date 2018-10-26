package acer.allen.oop;

/**
 * 培根披萨
 * 
 * @author acer
 *
 */
public class Baconic extends Pizza {
	// 培根克数
	private int pizzaGram;

	public int getPizzaGram() {
		return pizzaGram;
	}

	public Baconic(int pizzaGram, int size, int price) {
		super(size, price);
		super.setName("培根披萨");
		this.pizzaGram = pizzaGram;
	}

	public void setPizzaGram(int pizzaGram) {
		this.pizzaGram = pizzaGram;
	}

	public Baconic() {
	}

	@Override
	public void show() {
		System.out.println("名称:" + super.getName() + "\n价格:" + super.getPrice() + "元\n大小:" + super.getSize()
				+ "寸\n培根克数:" + this.pizzaGram);
	}

}
