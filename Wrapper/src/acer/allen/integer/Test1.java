package acer.allen.integer;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// �������ͳ�������Ϊ10
		final int LEN = 10;
		// ʵ�������ͷ�װ������ ����Ϊ10
		Integer[] integer = new Integer[LEN];
		// ѭ�������ֵ
		for (int i = 0; i < LEN; i++) {
			// ͨ��˫���ȷ�װ��õ����ֵ
			Double d = (Math.random() * 100);
			integer[i] = Math.round(d.intValue());
		}
		// ��ӡδ����֮ǰ������
		System.out.println("δ����ǰ������Ϊ��");
		System.out.println(Arrays.toString(integer));
		// ��������
		// Arrays.sort(integer);
		// �����Զ������򷽷�
		sortNew(integer);
		// ��ӡ����֮�������
		System.out.println("����������Ϊ��");

		System.out.println(Arrays.toString(integer));
	}

	// �����Զ��巽��
	static void sortNew(Integer[] array) {
		int j = 0;
		int temp = 0;
		for (int key = array.length / 2; key > 0; key /= 2) {
			for (int i = key; i < array.length; i++) {
				temp = array[i];
				for (j = i; j >= key; j -= key) {
					if (temp < array[j - key]) {
						array[j] = array[j - key];
					} else {
						break;
					}
				}
				array[j] = temp;
			}
		}

	}

	// �Զ��巽��
	static void selectSort(int[] a) {
		if (a == null || a.length <= 0) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			int min = i;// ����ǰ�±궨��Ϊ��Сֵ�±�
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {// �����С�ڵ�ǰ��Сֵ�Ĺؼ���
					min = j;// ���˹ؼ��ֵ��±긳ֵ��min
				}
			}
			if (i != min) {// ��min������i,˵���ҵ���Сֵ,����
				int tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;

			}
		}
	}
}
