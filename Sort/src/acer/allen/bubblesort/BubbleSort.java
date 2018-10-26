package acer.allen.bubblesort;

import java.util.Arrays;

public class BubbleSort {
	// ����һ����10��Ԫ�ص���������
	static int[] array = new int[10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ѭ����ֵ[0,99]
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println("δ�����Ԫ��:");
		for (int i : array) {
			System.out.print(" "+i);
		}
		// ���÷���
		bubbleSort(array, array.length);
		//��ӡ����Ԫ��
		System.out.println("\n����֮���:\n"+Arrays.toString(array));
	}
	/**
	 * ����һ����̬��void�޷���ֵ�ķ���
	 * �β���2�������� a,���鳤��n
	 * */
	static void bubbleSort(int[] a, int n) {
		//���ѭ������ð�ݵ�����: length-1
		for (int i = 0; i < n - 1; i++) {
		boolean flag=false;
			//�ڲ�ѭ�����Ƶ����ҵ����ֵ����ջ��
			for (int j = 0; j < n - 1 - i; j++) {
				//�����ǰԪ�ش��ں�1λԪ��
				if (a[j] > a[j + 1]) {
					//����λ��
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag=true;
				}
			}
			if(!flag){
				System.out.println("���鱾���Ѿ�����");
				break;
			}
		}
	}
	//�Ľ�֮���ð������
	static void bubbleSort2(int[] a, int n) {
		//���ѭ������ð�ݵ�����: length-1
		int low=0;
		int high=n-1;
		int tem,j;
		
		while(low<high){
			for(j=low;j<high;++j){//����ð�ݣ��ҵ������
				if(a[j]>a[j+1]){
					tem=a[j];
					a[j]=a[j+1];
					a[j+1]=tem;
				}
				--high;
			}
			for(j=high;j>low;--j){//����ð�ݣ��ҵ���С��
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
