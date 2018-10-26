package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Test1 {
	// 实例化字符串
	static StringBuilder sb = new StringBuilder();

	// 实例化数组列表
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		// 添加元素
		addElements();
		// 打印
		showArrayList();
		// 删除相同元素
		removeSameElements(list);
		// 去空白
		list.trimToSize();
		/*
		 * Object[] o = list.toArray(); System.out.println((String) o[0]);
		 */
	}

	/**
	 * 随机生成字符串
	 * 
	 * @param sb
	 *            可变字符序列 非线程安全
	 * @return 返回字符串
	 */
	@SuppressWarnings("unused")
	static String getString(StringBuilder sb) {
		String s = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
		// 随机数实例化
		Random random = new Random();
		// 循环得到随机字符
		for (int j = 0; j < s.length(); j++) {
			int r = random.nextInt(s.length());
			sb.append(s.charAt(r));
			break;
		}
		return sb.toString();
	}

	/**
	 * 添加数组列表元素
	 * 
	 */
	static void addElements() {
		// 循环添加数据
		for (int i = 0; i < 50; i++) {
			list.add(getString(sb));
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	/**
	 * 删除相同的元素
	 */
	static void removeSameElements(ArrayList<String> list) {
		System.err.println("\n原来的数据为:\n\n" + list);
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				String temp = list.get(j);
				if (s.equals(temp)) {
					list.remove(j);
					j--;
				}
			}
		}
		System.err.println("\n删除重复元素后的数据为：\n\n" + list);
	}

	/**
	 * 打印数组列表元素
	 */
	static void showArrayList() {

		System.err.println("-----------------------------------遍历方法1：-------------------------\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("第%d个数据是%s\n", i + 1, list.get(i));
		}
		System.err.println("-----------------------------------遍历方法2：-------------------------\n");
		int i = 0;
		for (String string : list) {
			System.out.printf("第%d个数据是%s\n", i + 1, string);
			i++;
		}
		System.err.println("-----------------------------------遍历方法3：-------------------------\n");
		// 实例化迭代器
		Iterator<String> it = list.iterator();
		i = 0;
		// 循环条件为 游标是否还能找到下一个数据
		while (it.hasNext()) {
			// 找到了 打印游标找到的数据
			System.out.printf("第%d个元素是%s\n", i + 1, it.next());
			i++;

		}
	}

}
