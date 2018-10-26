package acer.allen.oop;

/**
 * ����������
 * 
 * @author acer
 *
 */
public class PizzaFactory {
	public static Pizza getInstance(int num,int size,int price,String dosing,int pizzaGram) {
		Pizza p = null;
		switch (num) {
		case 1:
			p = new Baconic(pizzaGram, size, price);
			break;
		case 2:
			p = new SeaFood(size, price, dosing);
			
			break;
		default:
			System.out.println("û���ҵ����࣡");
		}
		return p;
	}

}
