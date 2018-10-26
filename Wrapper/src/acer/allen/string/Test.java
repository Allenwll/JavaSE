package acer.allen.string;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// ���ͳ��� LEN����Ϊ20
		final int LEN = 20;

		// �����ַ�����
		char[] c = new char[LEN];

		// ����ѭ��
		int count = 0;

		// ���ַ�������и�ֵ
		while (count < LEN) {

			// ͨ���õ������ͽ�������ж�
			int result = getMyChar();

			if (result > 0) {

				// ������ֵ����ÿ��Ԫ��
				c[count] = (char) result;

				// ����
				count++;
			}
		}
		// �Զ������ַ�����ת����Ϊ�ַ���
		String str = new String(c);

		// ��ת������ַ�����ӡ��
		System.out.println("ԭ�����ַ���Ϊ:\n\t" + str);

		// ��ԭ�����ַ��� ���д�Сдת����
		String newStr = getStr(str);

		// ��ת������ַ�����ӡ��
		System.out.println("���ַ���Ϊ:\n\t" + newStr);

		// �ֱ�������Ϊ5,10,15,20������;
		newStr = insertStr(newStr, ";");

		// ���������ַ�����ӡ��
		System.out.println("����';'����ַ���Ϊ:\n\t" + newStr);

		// ���ַ�������洢��ȡ����ַ���
		String[] stringNew = newStr.split(";");

		// ���ַ��������ӡ��
		System.out.println("չʾ�µ��ַ���:\n\t" + Arrays.toString(stringNew));

		// �������ÿ��Ԫ�ؽ�������
		// String myString =
		// stringNew[0].concat(stringNew[1]).concat(stringNew[2]).concat(stringNew[3]);

		// Ԫ���Ƿ������a��
		isElement(stringNew, 'a');
	}

	/**
	 * �õ�����ַ� ['a'-'Z'] [65-122]
	 * 
	 * @return
	 */
	static int getMyChar() {

		// �õ���ֵ 122 'z' 65 'A'
		int dis = 'z' - 'A' + 1;

		// ����õ� 'A'-'Z'�е����ֵ
		int random = (int) (Math.random() * dis) + 'A';
		/*
		 * // ����õ���ֵ��[A-Z]֮�� if (random >= 'A' && random <= 'Z')
		 * 
		 * // ���� ran return random;
		 * 
		 * // ����õ���ֵ��[a-z]֮�� if (random >= 'a' && random <= 'z')
		 * 
		 * // ���� ran return random;
		 * 
		 * // ����������������򷵻�-1
		 */
		if (random > 'z' || random < 'a')
			return -1;
		return random;
	}

	/**
	 * ��str���д�Сдת��
	 * 
	 * @param str
	 *            ԭ�ַ���
	 * @return ���ַ���
	 */
	static String getStr(String str) {
		// �õ��ַ��ĳ���
		int len = str.length();

		// ����һ����ʱ�ַ���
		String tempStr = "";

		for (int i = 0; i < len; i++) {
			// ѭ���õ��ַ����е�ÿ���ַ�����ֵ�� �ַ�c
			char c = str.charAt(i);
			// ���c ��['A'-'Z']֮��
			if (c >= 'A' && c <= 'Z')
				// ��c����Ӧ��ʮ��������32 �õ����Ӧ��Сд�ַ�
				c += 32;
			else {
				// ��c����Ӧ��ʮ��������32 �õ����Ӧ�Ĵ�д�ַ�
				c -= 32;
			}
			// ��+���ӷ����ַ���ϳ�һ���ַ���
			tempStr += c;

		}
		// �����ַ�������
		return tempStr;
	}

	/**
	 * ��ԭ�ַ����ϵĵ�5,10,15,20�����������;
	 * 
	 * @param str
	 *            ԭ�ַ���
	 * @param separator
	 *            ��ӵ�;�ַ�
	 * @return �������֮����ַ���
	 */
	static String insertStr(String str, String separator) {
		// ������ʱ������
		int index = 0;

		StringBuffer sb = new StringBuffer();
		/*
		 * String sub = str.substring(index, index + 5); index += 5; return
		 * sub.concat(separator) + sub1.concat(separator) +
		 * sub2.concat(separator) + sub3.concat(separator);
		 */
		sb.append(str.substring(index, index + 5) + separator);
		for (int i = 0; i < 3; i++) {
			index += 5;
			sb.append(str.substring(index, index + 5) + separator);
			if (index > 20)
				break;
		}
		return sb.toString();
	}

	static void isElement(String[] str, char c) {
		for (int i = 0; i < str.length; i++) {
			int len = str[i].length();
			for (int j = 0; j < len; j++) {
				char ch = str[i].charAt(j);
				if (ch == c) {
					System.out.println("\n�����ַ�[" + c + "]��Ԫ����" + str[i]);
					break;
				}
			}
		}
	}

	/**
	 * �õ�������ɵ�һ���ַ���
	 * 
	 * @param length
	 *            �ַ�������
	 * @return
	 */
	public static String getRandomString(int length) {
		// ����һ���ַ���
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// ʵ����һ�����������
		Random random = new Random();

		// ʵ����һ���ַ���������
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {
			// ����һ��number �洢�õ������������
			int number = random.nextInt(str.length());

			// ����������Ӧ��str�ϵ��ַ�׷�ӵ��ַ���������
			sb.append(str.charAt(number));
		}
		// �����ַ���
		return sb.toString();
	}

}
