package array;

import java.util.Arrays;

/**
 * ���鸴��
 * 
 * @author Allen
 *
 */
public class ArrayCopy {

	/**
	 * ��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// �������ͳ���
		final int LEN = 100;
		// ��������
		int[] a = new int[LEN];
		int[] b = new int[LEN];
		// ��̬��ֵ
		for (int i = 0; i < LEN; i++) {
			a[i] = (int) (Math.random() * LEN);
		}
		System.out.println("��һ�������ֵ:" + Arrays.toString(a));
		System.out.println("�ڶ��������ֵ:" + Arrays.toString(b));
		// ���Ƶ�һ������ǰ50��Ԫ�ص��ڶ�������
		System.arraycopy(a, 0, b, 0, 50);
		System.out.println("�ڶ��������ֵ:" + Arrays.toString(b));
	}
}
