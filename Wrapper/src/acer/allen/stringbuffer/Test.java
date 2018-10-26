package acer.allen.stringbuffer;

import java.util.Random;

public class Test {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		 
		sb=getRandomString(30);
		
		// ��ӡsb��Ϣ
		showSb(sb);
		
		//ɾ��sb�еĴ�д��ĸ
		System.out.println("\nȥ���ַ����������ڵĴ�д��ĸ�Ժ�\n");
		delUpperCase(sb);
		
		//��ӡsb��Ϣ
		showSb(sb);
		
		//����trimToSize����
		System.out.println("\nȥ���ַ����������ڵĿո��Ժ�\n");
		sb.trimToSize();
		
		//��ӡsb��Ϣ
		showSb(sb);
	}

	/**
	 * ����һ���������ڵõ�������ַ�
	 */

	public static StringBuffer getRandomString(int length) {
		// ����һ���ַ���
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// ʵ����һ�����������
		Random random = new Random();

		// ʵ����һ���ַ���������

		for (int i = 0; i < length; i++) {

			// ����һ��number �洢�õ������������
			int number = random.nextInt(str.length());

			// ����������Ӧ��str�ϵ��ַ�׷�ӵ��ַ���������
			sb.append(str.charAt(number));
		}
		return sb;
	}

	/**
	 * ��ʾsb����Ϣ
	 * 
	 * @param sb
	 *            �ַ���������
	 */
	public static void showSb(StringBuffer sb) {
		System.out.println("�ַ���������Ϊ��" + sb.capacity());
		System.out.println("-----------------------------------------------------");
		System.out.println("�ַ����ĳ����ǣ�" + sb.length());
		System.out.println("-----------------------------------------------------");
		System.out.println("�ַ��������ǣ�" +sb.toString());
		System.out.println("-----------------------------------------------------");
	}
	/**
	 * ɾ��sb�еĴ�д��ĸ
	 */
	public static void delUpperCase(StringBuffer sb){
		for (int i = 0; i < sb.length(); i++) {
			char c=sb.charAt(i);
			if(c>='A'&&c<='Z'){
				sb.deleteCharAt(i);
				i--;
			}
		}
	}
}
