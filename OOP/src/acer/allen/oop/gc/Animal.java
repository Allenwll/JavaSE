package acer.allen.oop.gc;

public class Animal {
	Cat cat = new Cat();
	private String name;
	public Animal(String name) {
		this.name=name;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("垃圾回收器执行finalize方法！ name="+name);
	}

	void destory() {
		cat = null;
		System.gc();
	}
}
