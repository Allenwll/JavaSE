package acer.allen.selectsort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] arr={49,38,65,97,76,13,27,14,10};
			System.out.println("����֮ǰ��:"+Arrays.toString(arr));
			selectSort(arr);
			System.out.println("����֮���:"+Arrays.toString(arr));
			
	}
	static void selectSort(int[] a){
		if(a==null||a.length<=0){
			return;
		}
		for (int i = 0; i < a.length; i++) {
			int min=i;//����ǰ�±궨��Ϊ��Сֵ�±�
			for(int j=i+1;j<a.length;j++){
				if(a[min]>a[j]){//�����С�ڵ�ǰ��Сֵ�Ĺؼ���
					min=j;//���˹ؼ��ֵ��±긳ֵ��min
				}
			}
			if(i!=min){//��min������i,˵���ҵ���Сֵ,����
				int tmp=a[min];
				a[min]=a[i];
				a[i]=tmp;
				
			}
		}
	}

}
