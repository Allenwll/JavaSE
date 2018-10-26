package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = 0, b = 0, c = 0;
		try {
			System.out.println("�������һ���ߵı߳�:");
			a = s.nextInt();
			System.out.println("������ڶ����ߵı߳�:");
			b = s.nextInt();
			System.out.println("������������ߵı߳�:");
			c = s.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("������������");
			System.exit(0);
		}
		isTriangle(a, b, c);
	}

	static void isTriangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			if (a - b < c && a - c < b && b - c < a) {
				System.out.println("���Թ��������Σ�");
				return;
			} else {
				throw new IllegalArgumentException("a,b,c���ܹ���������");
			}
		} else {
			throw new IllegalArgumentException("a,b,c���ܹ���������");
		}
	}
}
