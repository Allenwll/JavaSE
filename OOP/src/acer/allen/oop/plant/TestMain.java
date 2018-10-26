package acer.allen.oop.plant;

/**
 * �����
 * 
 * @author acer
 *
 */
public class TestMain {
	public static  Plant p; 
	public static void main(String[] args) {
		show("Flower");
		show("Grass");
		show("Tree");
	}

	static void show(String str) {
		p = PlantFactory.getInstance(str);
		if(p!=null){
			p.grow();
			System.out.println(p);
			p.die();
		}else{
			System.out.println("û�ж������ɣ�");
		}
		
	}
}
