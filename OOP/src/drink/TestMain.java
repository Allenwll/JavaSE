package drink;

import java.util.Scanner;

public class TestMain {
	static String dosing, myName;
	static int number;
	static int num;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("请选择饮料(1.咖啡2.矿泉水3.可乐)：");
		num = s.nextInt();
		choice(num);
	}

	static void choice(int num) {
		if (num == 1 || num == 2 || num == 3) {
			System.out.println("请输入购买的容量:");
			int volume = s.nextInt();
			if (num == 1) {
				System.out.println("请问是否需要配料：(1、加糖 2、加奶 3、什么都不加)");
				number = s.nextInt();
				select(number);
			} else if (num == 3) {
				System.out.println("请选择购买可口可乐还是百事可乐(1.可口可乐 2.百事可乐)");
				int i = s.nextInt();
				if (i == 1)
					myName = "可口可乐";
				else if (i == 2)
					myName = "百事可乐";
				else {
					System.out.println("请输入1或者2！");
					return;
				}
			}
			Drink d=DrickFactory.getInstance(num);
			d.setVolume(volume);
			d.show();
		} else {
			System.out.println("请输入1,2,3中的其中一个数字！");
			return;
		}
	}

	static void select(int a) {
		switch (a) {
		case 1:
			dosing = "加糖";
			break;
		case 2:
			dosing = "加奶";
			break;
		case 3:
			dosing = "无";
			break;
		default:
			System.out.println("请选择正确的数字!");

		}
	}

}
