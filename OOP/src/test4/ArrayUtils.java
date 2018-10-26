package test4;

import java.util.Arrays;

public class ArrayUtils {
	public static final void setArrayValues(Object[] array, int max) {
		for (int i = 0; i < array.length; i++) {
			int score = (int) Math.round(Math.random() * max);
			array[i] = new Student(score);
		}
	}

	public static final void setArrayValue(Object[] array, int max) {
		for (int i = 0; i < array.length; i++) {
			int num = (int) Math.round(Math.random() * max);
			array[i] = new News(num);
		}
	}

	/**
	 * 数组显示
	 * 
	 * @param array
	 */
	public static final void showArrayValues(Object[] array) {
		System.out.println(Arrays.toString(array));
	}

	// 引用数据类型排序
	public static final void sort(Object[] array) {
		Object temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				Student stu = (Student) array[j];
				Student stu1 = (Student) array[j + 1];
				if (stu.compareTo(stu1) < 0) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}

		}
	}

	// 引用数据类型排序
	public static final void sortNew(Object[] array) {
		Object temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				News n = (News) array[j];
				News n1 = (News) array[j + 1];
				if (n.compareTo(n1) > 0) {
					temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;

				}

			}

		}
	}

}
