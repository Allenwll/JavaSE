package acer.allen.pattern;

import java.util.Scanner;

/**
 * ͳ���ַ��ĸ��� 1����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
 * 
 * @author acer
 *
 */
public class Test2 {

	public static void main(String[] args) {

		// ����
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("������һ���ַ���");

		String str = s.nextLine();// ��������

		// ����
		String E1 = "[\u4e00-\u9fa5]";// ����
		String E2 = "[a-zA-Z]";// ��ĸ
		String E3 = "[0-9]";// ����
		String E4 = "\\s";// �ո�

		// ����
		int couChinese = 0;
		int couLetter = 0;
		int coutNumber = 0;
		int couSpace = 0;
		int couOther = 0;

		char[] array_char = str.toCharArray();// ת���ַ�����

		String[] array_str = new String[array_char.length];// ת���ַ�������

		// ������ֵ
		for (int i = 0; i < array_str.length; i++) {
			array_str[i] = String.valueOf(array_char[i]);
		}

		for (String string : array_str) {
			if (string.matches(E1))
				couChinese++;
			else if (string.matches(E2))
				couLetter++;
			else if (string.matches(E3))
				coutNumber++;
			else if (string.matches(E4))
				couSpace++;
			else
				couOther++;
		}

		System.out.println("��������ַ���ͳ�ƵĽ��Ϊ:");
		System.out.println("�����ַ�:" + couChinese + "��");
		System.out.println("Ӣ���ַ�:" + couLetter + "��");
		System.out.println("�����ַ�:" + coutNumber + "��");
		System.out.println("�հ��ַ�:" + couSpace + "��");
		System.out.println("�����ַ�:" + couOther + "��");

	}

}
