package acer.allen.oop.gc;

public class Animal {
	Cat cat = new Cat();
	private String name;
	public Animal(String name) {
		this.name=name;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("����������ִ��finalize������ name="+name);
	}

	void destory() {
		cat = null;
		System.gc();
	}
}
