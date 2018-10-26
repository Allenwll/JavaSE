package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		// 实例化
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 调用添加元素方法
		addElements(list);
		// 打印
		System.err.println("原来的--------------------------------------------\n");
		showElements(list);
		// 去除奇数
		removeNum(list);
		// 打印
		System.err.println("\n\n去奇数后------------------------------------------\n");
		showElements(list);
	}

	/**
	 * 添加元素
	 */
	static void addElements(ArrayList<Integer> list) {
		for (int i = 0; i < 20; i++) {
			list.add(getNum());
		}
	}

	/**
	 * 得到随机数
	 */
	static int getNum() {
		// 实例化随机数
		Random random = new Random();
		// 得到随机数
		int i = random.nextInt(10);
		return i;
	}

	/**
	 * 去除奇数
	 */
	static void removeNum(ArrayList<Integer> list) {
		ListIterator<Integer> it = list.listIterator();
		while (it.hasNext()) {
			Integer i = it.next();
			if (i % 2 == 1)
				it.remove();
		}
	}

	/**
	 * 打印元素
	 * 
	 */
	static void showElements(ArrayList<Integer> list) {
		for (Integer integer : list) {
			System.out.print(" " + integer);
		}
	}
}
