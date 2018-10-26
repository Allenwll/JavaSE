package acer.allen.integer;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// 定义整型常量长度为10
		final int LEN = 10;
		// 实例化整型封装类数组 长度为10
		Integer[] integer = new Integer[LEN];
		// 循环随机赋值
		for (int i = 0; i < LEN; i++) {
			// 通过双精度封装类得到随机值
			Double d = (Math.random() * 100);
			integer[i] = Math.round(d.intValue());
		}
		// 打印未排序之前的数组
		System.out.println("未排序前的数组为：");
		System.out.println(Arrays.toString(integer));
		// 进行排序
		// Arrays.sort(integer);
		// 调用自定义排序方法
		sortNew(integer);
		// 打印排序之后的数组
		System.out.println("排序后的数组为：");

		System.out.println(Arrays.toString(integer));
	}

	// 定义自定义方法
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

	// 自定义方法
	static void selectSort(int[] a) {
		if (a == null || a.length <= 0) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			int min = i;// 将当前下标定义为最小值下标
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {// 如果有小于当前最小值的关键字
					min = j;// 将此关键字的下标赋值给min
				}
			}
			if (i != min) {// 若min不等于i,说明找到最小值,交换
				int tmp = a[min];
				a[min] = a[i];
				a[i] = tmp;

			}
		}
	}
}
