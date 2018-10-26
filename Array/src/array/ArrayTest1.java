package array;

import java.util.Arrays;

/**
 * @author acer ��ά���� �﷨: int[][] arrays; ��̬��ʼ��:arrays=new int[3][4];
 *         �����õ�γ��һά�����Ԫ��������ͬ int [][] array=new int[3][]; array[0]=new int[5];
 *         array[1]=new int[15]; array[2]=new int[55]; ��̬��ʼ��
 *         int[][]arr={{1,2},{2,3,4}};
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		final int LEN = 9;
		// ��̬��ֵ
		int[][] array;
		array = new int[LEN][];
		// ������Ԫ�ظ�ֵ
		for (int i = 0; i < array.length; i++) {
			// ��ÿ��һά������䲻ͬ���ڴ�ռ�
			array[i] = new int[i + 1];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = ((i + 1) * (j + 1));
			}
		}
		// ��ӡ
		for (int[] is : array) {
			System.out.println(Arrays.toString(is));
		}
	}

}
