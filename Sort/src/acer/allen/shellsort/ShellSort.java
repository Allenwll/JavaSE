package acer.allen.shellsort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 1, 5, 7, 2, 4, 9, 6 };
		System.out.println("Î´ÅÅĞòÇ°£º");
		System.out.println(Arrays.toString(a));
		shellSort(a);
		System.out.println("\nÅÅĞòºó£º");
		System.out.println(Arrays.toString(a));
	}

	static void shellSort(int a[]) {
		int j = 0;
		int temp = 0;
		for (int key = a.length / 2; key > 0; key /= 2) {
			for (int i = key; i < a.length; i++) {
				temp = a[i];
				for (j = i; j >= key; j -= key) {
					if (temp > a[j - key]) {
						a[j] = a[j - key];
					} else {
						break;
					}
				}
				a[j] = temp;
			}
		}

	}

}
