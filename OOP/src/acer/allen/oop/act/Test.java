package acer.allen.oop.act;

public class Test {
	public static void main(String[] args) {
		Athlete a = new Athlete("刘晓翔", 23, "男", "200米短跑", "22秒30");
		a.introduce();
		System.out.println("=============================");
		Actor ac = new Actor("张怡", 27, "女", "北京电影学院", "《寄往天国的家书》");
		ac.introduce();
	}
}
