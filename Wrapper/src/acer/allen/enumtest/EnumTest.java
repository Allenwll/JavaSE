package acer.allen.enumtest;

import java.util.Scanner;

public class EnumTest {
	enum Color {
		RED, GREEN, YELLOW
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入交通信号灯的颜色:");
		try {
			String color = s.next();
			color = color.toUpperCase();
			switch (color) {
			case "RED":
				show(textEnum(Color.RED));
				break;
			case "GREEN":
				show(textEnum(Color.GREEN));
				break;
			case "YELLOW":
				show(textEnum(Color.YELLOW));
				break;

			}
		} catch (Exception e) {
			System.out.println("请检查！");
		}
	}

	static void show(String str) {
		System.out.println("当前汽车状态是:" + str);
	}

	static String textEnum(Color c) {
		switch (c) {
		case RED:
			return "汽车停车";
		case GREEN:
			return "汽车行驶";
		case YELLOW:
			return "汽车慢行";
		}
		return "";
	}
}
