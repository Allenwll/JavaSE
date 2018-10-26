package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) /*throws ArithmeticException, InputMismatchException */{

		try {
			divide();
		} catch (ArithmeticException e) {
			System.err.println("除数不能为零。");
			System.exit(1);
		} catch (InputMismatchException e) {
			System.err.println("出现错误：被除数和除数必须是整数 ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("谢谢使用！");
		}
	}

	@SuppressWarnings("resource")
	public static void divide() throws ArithmeticException, InputMismatchException {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入被除数:");
		// 可能出现异常的代码
		int a = s.nextInt();
		System.out.println("请输入除数:");
		int b = s.nextInt();
		System.out.println(String.format("被除数%d除以除%d得商%d", a, b, a / b));
	}

}
