package acer.allen.oop.plant;

/**
 * 植物工厂
 * 
 * @author acer
 *
 */
public final class PlantFactory {
	public static Plant getInstance(String str) {
		Plant p = null;
		switch (str) {
		case "Grass":
			p = new Grass("幸运草", 1.2, false, false); 
			break;
		case "Flower":
			p = new Flower("小雏菊", 0.5,"橘黄色" , 5);
			break;
		case "Tree":
			p = new Tree("梧桐", 500, 1000, 10);
			break;
			default:
				System.out.println("没有找到合适的类！");
		}
		return p;
	}
}
