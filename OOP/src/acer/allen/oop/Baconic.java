package acer.allen.oop;

/**
 * �������
 * 
 * @author acer
 *
 */
public class Baconic extends Pizza {
	// �������
	private int pizzaGram;

	public int getPizzaGram() {
		return pizzaGram;
	}

	public Baconic(int pizzaGram, int size, int price) {
		super(size, price);
		super.setName("�������");
		this.pizzaGram = pizzaGram;
	}

	public void setPizzaGram(int pizzaGram) {
		this.pizzaGram = pizzaGram;
	}

	public Baconic() {
	}

	@Override
	public void show() {
		System.out.println("����:" + super.getName() + "\n�۸�:" + super.getPrice() + "Ԫ\n��С:" + super.getSize()
				+ "��\n�������:" + this.pizzaGram);
	}

}
