package acer.allen.oop;

/**
 * 比萨类
 * 
 * @author acer
 *
 */
public abstract class Pizza {
	// 名称
	private String name;
	// 价格
	private int price;
	// 大小
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

	// 展示
	public abstract void show();
}
