package acer.allen.oop;

/**
 * ������
 * 
 * @author acer
 *
 */
public abstract class Pizza {
	// ����
	private String name;
	// �۸�
	private int price;
	// ��С
	private int size;

	public Pizza(int size, int price) {
		this.size = size;
		this.price = price;
	}

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// չʾ
	public abstract void show();
}
