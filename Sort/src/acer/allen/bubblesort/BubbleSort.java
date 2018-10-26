package acer.allen.bubblesort;

import java.util.Arrays;

public class BubbleSort {
	// 定义一个有10个元素的整型数组
	static int[] array = new int[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 循环赋值[0,99]
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println("未排序的元素:");
		for (int i : array) {
			System.out.print(" "+i);
		}
		// 调用方法
		bubbleSort(array, array.length);
		//打印数组元素
		System.out.println("\n排序之后的:\n"+Arrays.toString(array));
	}
	/**
	 * 定义一个静态的void无返回值的方法
	 * 形参有2个：数组 a,数组长度n
	 * */
	static void bubbleSort(int[] a, int n) {
		//外层循环控制冒泡的趟数: length-1
		for (int i = 0; i < n - 1; i++) {
		boolean flag=false;
			//内层循环控制单趟找到最大值放在栈顶
			for (int j = 0; j < n - 1 - i; j++) {
				//如果当前元素大于后1位元素
				if (a[j] > a[j + 1]) {
					//交换位置
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag=true;
				}
			}
			if(!flag){
				System.out.println("数组本身已经有序！");
				break;
			}
		}
	}
	//改进之后的冒泡排序
	static void bubbleSort2(int[] a, int n) {
		//外层循环控制冒泡的趟数: length-1
		int low=0;
		int high=n-1;
		int tem,j;
		
		while(low<high){
			for(j=low;j<high;++j){//正向冒泡，找到最大者
				if(a[j]>a[j+1]){
					tem=a[j];
					a[j]=a[j+1];
					a[j+1]=tem;
				}
				--high;
			}
			for(j=high;j>low;--j){//反向冒泡，找到最小者
				if(a[j]<a[j-1]){
					tem=a[j];
					a[j]=a[j-1];
					a[j-1]=tem;
				}
				++low;
			}
		}
		
	}

}
