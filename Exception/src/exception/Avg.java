package exception;

import java.util.Scanner;

public class Avg {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("���������ڼ�������ƽ��ֵ,����������Ҫ����������ĸ���:");
		try {
			int len = s.nextInt();
			if (len < 0) {
				throw new Exception();
			}
			int sum = 0;
			for (int i = 0; i < len; i++) {
				System.out.println(String.format("�������%d����:", i + 1));
				int num = s.nextInt();
				if (num < 0) {
					throw new Exception();
				}
				sum += num;
			}
			System.out.println("������ƽ��ֵΪ:" + (sum / len));
		} catch (ArithmeticException e) {
			System.out.println("��������������");
		} catch (Exception e) {
			System.err.println("����������������������㣡���ٴ����������");
		}
	}

}
