package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) /*throws ArithmeticException, InputMismatchException */{

		try {
			divide();
		} catch (ArithmeticException e) {
			System.err.println("��������Ϊ�㡣");
			System.exit(1);
		} catch (InputMismatchException e) {
			System.err.println("���ִ��󣺱������ͳ������������� ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("ллʹ�ã�");
		}
	}

	@SuppressWarnings("resource")
	public static void divide() throws ArithmeticException, InputMismatchException {
		Scanner s = new Scanner(System.in);
		System.out.println("�����뱻����:");
		// ���ܳ����쳣�Ĵ���
		int a = s.nextInt();
		System.out.println("���������:");
		int b = s.nextInt();
		System.out.println(String.format("������%d���Գ�%d����%d", a, b, a / b));
	}

}
