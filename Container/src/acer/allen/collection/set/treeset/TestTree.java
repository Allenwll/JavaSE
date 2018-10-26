package acer.allen.collection.set.treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author acer
 *
 */
public class TestTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		set.add(3);
		set.add(188);
		set.add(54);
		set.add(125);
		set.add(3);
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

	}
}
