package acer.allen.oop.interface1;

/**
 * ����� �൥�̳е����Զ�ʵ�� �ӿڵĶ�ʵ��״̬�£��ӿڵķ������붼Ҫ��д �ͱ����˶�̳��ж�����෽����ͻ��ȱ��
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
