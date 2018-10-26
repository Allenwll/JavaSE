package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = 0, b = 0, c = 0;
		try {
			System.out.println("请输入第一个边的边长:");
			a = s.nextInt();
			System.out.println("请输入第二个边的边长:");
			b = s.nextInt();
			System.out.println("请输入第三个边的边长:");
			c = s.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("请输入整数！");
			System.exit(0);
		}
		isTriangle(a, b, c);
	}

	static void isTriangle(int a, int b, int c) {
		if (a + b > c && a + c > b && b + c > a) {
			if (a - b < c && a - c < b && b - c < a) {
				System.out.println("可以构成三角形！");
				return;
			} else {
				throw new IllegalArgumentException("a,b,c不能构成三角形");
			}
		} else {
			throw new IllegalArgumentException("a,b,c不能构成三角形");
		}
	}
}
