package acer.allen;

import java.util.Scanner;

public class ToBinary {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		try {
			System.out.println("������ʮ����������");
			int sum=s.nextInt();
			int i = 0;
			String str = "";
			while (true) {
				i = sum % 2;
				str = i + str;
				if (sum == 0) {
					break;
				}
				sum >>= 1;
			}
			System.out.println("��������Ϊ:" + str);
		} catch (Exception e) {
			System.err.println("������Ϸ������֣�");
		}
	}

}