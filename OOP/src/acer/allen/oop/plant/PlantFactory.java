package acer.allen.oop.plant;

/**
 * ֲ�﹤��
 * 
 * @author acer
 *
 */
public final class PlantFactory {
	public static Plant getInstance(String str) {
		Plant p = null;
		switch (str) {
		case "Grass":
			p = new Grass("���˲�", 1.2, false, false); 
			break;
		case "Flower":
			p = new Flower("С����", 0.5,"�ٻ�ɫ" , 5);
			break;
		case "Tree":
			p = new Tree("��ͩ", 500, 1000, 10);
			break;
			default:
				System.out.println("û���ҵ����ʵ��࣡");
		}
		return p;
	}
}
