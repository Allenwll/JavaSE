package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Test3 {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		// 实例化
		ArrayList<String> list = new ArrayList<String>();
		// 调用添加元素方法
		addElements(list);
		// 打印
		System.err.println("-------------------原来的元素-------------------------\n");
		showElements(list);
		// 调用添加新元素方法
		addNewElements(list);
		System.err.println("\n-------------------修改后的元素------------------------\n");
		showElements(list);
	}

	/**
	 * 两个相邻的元素相同，添加新元素
	 */
	static void addNewElements(ArrayList<String> list) {
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			String str = it.next();
			int index = it.previousIndex();
			// 如果是最后一个元素 结束循环
			if (index == (list.size() - 1)) {
				break;
			}
			String perStr = list.get(index+1);
			if (perStr.equals(str)) {
				it.add(str.toLowerCase());
			}

		}

	}
	/**
	 * 两个相邻的元素相同，添加新元素
	 */
	static void addNewElement(ArrayList<String> list) {
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			String str = it.next();
			int index = it.previousIndex();
			// 如果是最后一个元素 结束循环
			if (index == (list.size() - 1)) {
				break;
			}
			String perStr = list.get(index);
			String nextStr=list.get(index+1);
			if (perStr.equals(nextStr)) {
				it.add(str.toLowerCase());
			}

		}

	}

	/**
	 * 添加元素
	 * 
	 * @param list
	 *            字符数组列表
	 */
	private static void addElements(ArrayList<String> list) {
		for (int i = 0; i < 20; i++) {
			list.add(getStringNum(sb));
			sb.deleteCharAt(sb.length() - 1);

		}
	}

	/**
	 * 得到随机数
	 */
	static String getStringNum(StringBuffer sb) {
		String s = "ABCDEF";

		// 实例化随机数
		Random random = new Random();
		// 得到随机数
		int i = random.nextInt(s.length());
		sb.append(s.charAt(i));
		return sb.toString();
	}

	/**
	 * 打印元素
	 * 
	 */
	static void showElements(ArrayList<String> list) {
		for (String str : list) {
			System.out.print(" " + str);
		}
	}
}
