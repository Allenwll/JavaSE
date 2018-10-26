package array;

import java.util.Arrays;

/**
 * ����һ���������� ��̬��ʼ���������ֵ[0-99]
 **/
public class ArrayTest {
	static int count = 0;

	public static void main(String[] args) {
		// �������ͳ���
		final int LEN = 100;
		// ���鶯̬��ʼ��
		int[] array = new int[LEN];
		// ѭ���������ֵ
		for (int i = 0; i < LEN; i++) {
			array[i] = (int) (Math.random() * LEN);
		}
		// ��������
		Arrays.sort(array);
		// ��ӡ����
		System.out.println("�������в�ѯԪ��Ϊ20:\n"+Arrays.toString(array));
		System.out.println("�����ֵ�������:" + binarySearch(array, 0, LEN, 20));
	}
	
	// ������ַ�����(�۰����)
	static int binarySearch(int[] a, int start, int end, int key) {
		int mid = 0; // �൱��ָ��Ķ���
		for (int i = 0; i < a.length/2; i++) {
			mid = (start + end) / 2;
			if (a[mid] < key) {
				start = mid + 1;
			} else if (a[mid] > key) {
				end = mid - 1;
			} else {
				break;
			}
			if (start > end) {
				return -1;
			}
			count++;
		}
		System.out.println("һ������" + count + "�Σ�");
		return mid;
	}

}
