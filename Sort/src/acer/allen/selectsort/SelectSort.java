package acer.allen.selectsort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] arr={49,38,65,97,76,13,27,14,10};
			System.out.println("排序之前的:"+Arrays.toString(arr));
			selectSort(arr);
			System.out.println("排序之后的:"+Arrays.toString(arr));
			
	}
	static void selectSort(int[] a){
		if(a==null||a.length<=0){
			return;
		}
		for (int i = 0; i < a.length; i++) {
			int min=i;//将当前下标定义为最小值下标
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j]){//如果有小于当前最小值的关键字
					min=j;//将此关键字的下标赋值给min
				}
			}
			if(i!=min){//若min不等于i,说明找到最小值,交换
				int tmp=a[min];
				a[min]=a[i];
				a[i]=tmp;
				
			}
		}
	}

}
