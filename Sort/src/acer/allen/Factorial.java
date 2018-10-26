package acer.allen;

import java.util.Scanner;

//�Ʋ��������� 1,1,2,3,5,8����  
public class Factorial {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("����������Ҫ��쳲��������е�������");
		try {
			int result = s.nextInt();
			//showFeiBo(result);
			for (int i = 0; i <= result; i++) {
				System.out.print(" "+factorialFei(i)+" ");
			}
		} catch (Exception e) {
			System.err.println("���飡");
		}
	}

	/**
	 * �õ�쳲��������е����Ӧ����
	 * 
	 * @param n
	 * @return
	 */
	public static int factorialFei(int n) {
		// if(n==1||n==2)
		if (n < 3)
			return 1;
		else
			return factorialFei(n - 1) + factorialFei(n - 2);
	}

	static void showFeiBo(int n) {
		int a, b, c = 0;
		a = 1;
		b = 1;
		System.out.print("" + a + " " + b);
		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(" " + c + " ");
		}
	}
}
