package acer.allen.oop.interface1;

/**
 * 入口类 类单继承但可以多实现 接口的多实现状态下，接口的方法必须都要重写 就避免了多继承中多个父类方法冲突的缺点
 * 
 * @author acer
 *
 */
public class TestMain {
	public static void main(String[] args) {
		Bird b = new Bird();
		Plane p = new Plane();
		SuperMan s = new SuperMan();
		showFly(b,b);
		showFly(p,p);
		showFly(s,s);
	}
	static void showFly(Flyable flyable,Sleepable sleep){
		flyable.fly();
		sleep.sleep();
	}

}
