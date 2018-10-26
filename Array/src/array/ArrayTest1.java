package array;

import java.util.Arrays;

/**
 * @author acer 二维数组 语法: int[][] arrays; 动态初始化:arrays=new int[3][4];
 *         可以让低纬的一维数组的元素数量不同 int [][] array=new int[3][]; array[0]=new int[5];
 *         array[1]=new int[15]; array[2]=new int[55]; 静态初始化
 *         int[][]arr={{1,2},{2,3,4}};
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		final int LEN = 9;
		// 动态赋值
		int[][] array;
		array = new int[LEN][];
		// 对数组元素赋值
		for (int i = 0; i < array.length; i++) {
			// 给每个一维数组分配不同的内存空间
			array[i] = new int[i + 1];
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = ((i + 1) * (j + 1));
			}
		}
		// 打印
		for (int[] is : array) {
			System.out.println(Arrays.toString(is));
		}
	}

}
