package acer.allen.collection.set.hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
public class TestLinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet<Integer> set1 = new LinkedHashSet<>(123);

		// 面向接口
		Set<Integer> set = new HashSet<Integer>(123);
			show(set);
			show(set1);
	}

	static void show(Set<Integer> set) {
		set.add(3);
		set.add(123);
		set.add(4);
		set.add(125);
		set.add(23);
		set.add(323);
		System.err.println("----------原来元素---------------------");
		System.out.println(set.size());
		System.out.println(set);
		set.remove(123);
		System.err.println("----------删除123之后-----------------");
		System.out.println(set.size());
		System.out.println(set);
		System.out.println("-------foreach----------------------");
		// 遍历只能使用迭代器 Iterator 和 foreach（底层也是迭代器）
		for (Integer integer : set) {
			System.out.print(integer + "--");
		} // 迭代器
		System.out.println("\n-------iterator----------------------");

		java.util.Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "--");

		}
	}

}
