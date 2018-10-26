package entity;

/**
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 *
 * @Version 2016年8月21日
 * 
 *          实体类
 */
public class Mobile {

	// 序号
	private int id;

	// 品牌
	private String brand;

	// 类型
	private String model;

	// 价格
	private double price;

	// 数量
	private int count;

	// 版本
	private String version;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	// 无参构造
	public Mobile() {
	}

	// 有参构造
	public Mobile(int id, String brand, String model, double price, int count, String version) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.count = count;
		this.version = version;
	}

	@Override
	public String toString() {
		return "   "+id + " \t\t " + brand + " \t\t " + model + "       \t  " + price + " \t " + count + " \t     " + version;
	}

}
