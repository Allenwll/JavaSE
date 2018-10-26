package sort;

import java.util.Arrays;

public final class ArrayUtils {

	/**
	 * 双精度冒泡排序
	 * 
	 * @param array
	 *            形参数组 array.length-1 控制外层循环的趟数 array.length-1-i 控制内层循环的次数
	 */
	public static final void bubbleSort(double[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					// 交换位置
					double temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

		}
	}
	// 单精度冒泡排序

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
	// 长整型冒泡排序

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

	// 整型冒泡排序
	public static final void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					// 交换位置
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	// 短整型冒泡排序
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

	// 字节整型冒泡排序
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

	// 引用数据类型排序
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

	// 引用数据类型排序
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
	 * 给整数数组中的每个元素赋随机值
	 * 
	 * @param array
	 *            数组
	 * @param max
	 *            最大值
	 */
	public static final void setArrayValues(int[] array, int max) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * max);
		}
	}

	/**
	 * 引用数据类型赋值
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
	 * 整型显示
	 */
	public static final void showArrayValues(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 数组显示
	 * 
	 * @param array
	 */
	public static final void showArrayValues(Object[] array) {
		System.out.println(Arrays.toString(array));
	}

}
