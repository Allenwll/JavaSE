package drink;

import java.util.Scanner;

public class TestMain {
	static String dosing, myName;
	static int number;
	static int num;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("��ѡ������(1.����2.��Ȫˮ3.����)��");
		num = s.nextInt();
		choice(num);
	}

	static void choice(int num) {
		if (num == 1 || num == 2 || num == 3) {
			System.out.println("�����빺�������:");
			int volume = s.nextInt();
			if (num == 1) {
				System.out.println("�����Ƿ���Ҫ���ϣ�(1������ 2������ 3��ʲô������)");
				number = s.nextInt();
				select(number);
			} else if (num == 3) {
				System.out.println("��ѡ����ɿڿ��ֻ��ǰ��¿���(1.�ɿڿ��� 2.���¿���)");
				int i = s.nextInt();
				if (i == 1)
					myName = "�ɿڿ���";
				else if (i == 2)
					myName = "���¿���";
				else {
					System.out.println("������1����2��");
					return;
				}
			}
			Drink d=DrickFactory.getInstance(num);
			d.setVolume(volume);
			d.show();
		} else {
			System.out.println("������1,2,3�е�����һ�����֣�");
			return;
		}
	}

	static void select(int a) {
		switch (a) {
		case 1:
			dosing = "����";
			break;
		case 2:
			dosing = "����";
			break;
		case 3:
			dosing = "��";
			break;
		default:
			System.out.println("��ѡ����ȷ������!");

		}
	}

}
