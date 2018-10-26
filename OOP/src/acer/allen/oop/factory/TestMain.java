package acer.allen.oop.factory;

public class TestMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Animal a = MyFactory.getMyObj("Cat");
		a = MyFactory.getMyObj("Dog");
		MySingleTon single=MySingleTon.getInstatnce();
		single.test();
	}

}
