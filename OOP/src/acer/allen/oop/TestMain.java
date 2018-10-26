package acer.allen.oop;

import java.util.Scanner;

public class TestMain {
	static Pizza p;
	static String dosing;
	static int number;
	static int num;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("请选择想要制作的比萨(1.培根比萨2.海鲜比萨)：");
		num = s.nextInt();
		choice(num);
	}

	static void choice(int a) {
		if ((a==1)||(a==2)) {
			if (a == 1) {
				System.out.println("请输入培根克数：");
				number = s.nextInt();
			} else if (a == 2) {
				System.out.println("请输入配料信息:");
				dosing = s.next();
			}
			System.out.print("请输入比萨大小:");
			int size = s.nextInt();
			System.out.println("请输入比萨价格:");
			int price = s.nextInt();
			p = PizzaFactory.getInstance(a, size, price, dosing, number);
			p.show();
		}else{
			System.out.println("请输入1或者2！");
			return;
		}

	}

}
