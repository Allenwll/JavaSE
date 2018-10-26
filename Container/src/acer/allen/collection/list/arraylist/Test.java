package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// <> 泛型
		ArrayList<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("C#");
		list.add("Ruby");
		list.add("Python");
		list.add("Android");
		list.add("Android");
		// System.out.println(list);
		list.add(2, "CS");
		// System.out.println(list);
		list.remove("Android");
		list.remove(4);
		list.set(5, "OC");
		list.size();
		/*
		 * list.clear();清除 list.contains(o); 是否包含 list.indexOf(o); 返回索引值
		 * list.isEmpty(); 是否为空
		 */
		System.err.println("\n遍历方法1-----------------------\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.err.println("\n遍历方法2-----------------------\n");

		for (Object object : list) {
			System.out.println(object);
		}
		System.err.println("\n外部迭代器-----------------------\n");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
	}
}
