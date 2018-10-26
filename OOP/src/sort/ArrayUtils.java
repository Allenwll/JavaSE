package sort;

import java.util.Arrays;

public final class ArrayUtils {

	/**
	 * ˫����ð������
	 * 
	 * @param array
	 *            �β����� array.length-1 �������ѭ�������� array.length-1-i �����ڲ�ѭ���Ĵ���
	 */
	public static final void bubbleSort(double[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					// ����λ��
					double temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

		}
	}
	// ������ð������

	public static final void bubbleSort(float[] array) {
		float temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;

				}
			}

		}
	}
	// ������ð������

	public static final void bubbleSort(long[] array) {
		long temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;

				}
			}

		}
	}

	// ����ð������
	public static final void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					// ����λ��
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// ������ð������
	public static final void bubbleSort(short[] array) {
		short temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}

		}
	}

	// �ֽ�����ð������
	public static final void bubbleSort(byte[] array) {
		byte temp = 0;
		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;

				}
			}

		}
	}

	// ����������������
	public static final void sort(Object[] array) {
		Object temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				Student stu = (Student) array[j];
				Student stu1 = (Student) array[j + 1];
				if (stu.compareTo(stu1) > 0) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}

		}
	}

	// ����������������
	public static final void sort(Object[] array, Object com) {
		Object temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				Student stu = (Student) array[j];
				Student stu1 = (Student) array[j + 1];
				// IdCompartor compartor=(IdCompartor)com;
				Comparable2 compartor = (Comparable2) com;
				int result = compartor.compareTo(stu, stu1);
				if (result>0) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}

		}
	}

	/**
	 * �����������е�ÿ��Ԫ�ظ����ֵ
	 * 
	 * @param array
	 *            ����
	 * @param max
	 *            ���ֵ
	 */
	public static final void setArrayValues(int[] array, int max) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * max);
		}
	}

	/**
	 * �����������͸�ֵ
	 * 
	 * @param array
	 * @param max
	 */
	public static final void setArrayValues(Object[] array, int max) {
		for (int i = 0; i < array.length; i++) {
			int id = (int) Math.round(Math.random() * max);
			int score = (int) Math.round(Math.random() * max);
			int name=(int) Math.round(Math.random() * 20);
			array[i] = new Student(id, score,(char)('a'+name)+"");
		}
	}

	/**
	 * ������ʾ
	 */
	public static final void showArrayValues(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	/**
	 * ������ʾ
	 * 
	 * @param array
	 */
	public static final void showArrayValues(Object[] array) {
		System.out.println(Arrays.toString(array));
	}

}
