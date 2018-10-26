package acer.allen.enumtest;

import java.util.Scanner;

public class EnumTest {
	enum Color {
		RED, GREEN, YELLOW
	}

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("�����뽻ͨ�źŵƵ���ɫ:");
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
			System.out.println("���飡");
		}
	}

	static void show(String str) {
		System.out.println("��ǰ����״̬��:" + str);
	}

	static String textEnum(Color c) {
		switch (c) {
		case RED:
			return "����ͣ��";
		case GREEN:
			return "������ʻ";
		case YELLOW:
			return "��������";
		}
		return "";
	}
}
