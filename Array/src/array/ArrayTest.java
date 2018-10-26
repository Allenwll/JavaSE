package array;

import java.util.Arrays;

/**
 * 定义一个整形数组 动态初始化，随机赋值[0-99]
 **/
public class ArrayTest {
	static int count = 0;

	public static void main(String[] args) {
		// 定义整型常量
		final int LEN = 100;
		// 数组动态初始化
		int[] array = new int[LEN];
		// 循环随机数赋值
		for (int i = 0; i < LEN; i++) {
			array[i] = (int) (Math.random() * LEN);
		}
		// 数组排序
		Arrays.sort(array);
		// 打印数组
		System.out.println("在数组中查询元素为20:\n"+Arrays.toString(array));
		System.out.println("该数字的索引在:" + binarySearch(array, 0, LEN, 20));
	}
	
	// 定义二分法方法(折半查找)
	static int binarySearch(int[] a, int start, int end, int key) {
		int mid = 0; // 相当于指针的东西
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
		System.out.println("一共找了" + count + "次！");
		return mid;
	}

}
