package acer.allen.oop;

import java.util.Scanner;

public class TestMain {
	static Pizza p;
	static String dosing;
	static int number;
	static int num;
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("��ѡ����Ҫ�����ı���(1.�������2.���ʱ���)��");
		num = s.nextInt();
		choice(num);
	}

	static void choice(int a) {
		if ((a==1)||(a==2)) {
			if (a == 1) {
				System.out.println("���������������");
				number = s.nextInt();
			} else if (a == 2) {
				System.out.println("������������Ϣ:");
				dosing = s.next();
			}
			System.out.print("�����������С:");
			int size = s.nextInt();
			System.out.println("����������۸�:");
			int price = s.nextInt();
			p = PizzaFactory.getInstance(a, size, price, dosing, number);
			p.show();
		}else{
			System.out.println("������1����2��");
			return;
		}

	}

}
