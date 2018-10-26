package array;

import java.util.Arrays;

/**
 * 数组复制
 * 
 * @author Allen
 *
 */
public class ArrayCopy {

	/**
	 * 程序的入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 定义整型常量
		final int LEN = 100;
		// 定义数组
		int[] a = new int[LEN];
		int[] b = new int[LEN];
		// 动态赋值
		for (int i = 0; i < LEN; i++) {
			a[i] = (int) (Math.random() * LEN);
		}
		System.out.println("第一个数组的值:" + Arrays.toString(a));
		System.out.println("第二个数组的值:" + Arrays.toString(b));
		// 复制第一个数组前50的元素到第二个数组
		System.arraycopy(a, 0, b, 0, 50);
		System.out.println("第二个数组的值:" + Arrays.toString(b));
	}
}
