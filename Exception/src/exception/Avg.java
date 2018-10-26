package exception;

import java.util.Scanner;

public class Avg {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("本程序用于计算整数平均值,请您输入需要计算的整数的个数:");
		try {
			int len = s.nextInt();
			if (len < 0) {
				throw new Exception();
			}
			int sum = 0;
			for (int i = 0; i < len; i++) {
				System.out.println(String.format("请输入第%d个数:", i + 1));
				int num = s.nextInt();
				if (num < 0) {
					throw new Exception();
				}
				sum += num;
			}
			System.out.println("整数的平均值为:" + (sum / len));
		} catch (ArithmeticException e) {
			System.out.println("请输入正整数！");
		} catch (Exception e) {
			System.err.println("输入的数必须是正数或者零！请再次输入该数！");
		}
	}

}
