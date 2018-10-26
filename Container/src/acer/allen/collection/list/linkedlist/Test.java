package acer.allen.collection.list.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Allen
 * 
 * ArrayList 元素不唯一  有序
 * 
 *   底层用数组实现  线程不安全  查询快  增删改慢
 *   
 * Vector  元素不唯一 有序
 * 
 *   线程安全    效率比ArrayList低  
 *  
 * LinkedList  元素不唯一  有序
 * 
 *   底层用链表实现  内存不连续  增删改快  查询慢
 *
 */
public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// <> 泛型
		List<String> lists = new ArrayList<String>(); // 面向接口编程
		LinkedList<String> list = new LinkedList<String>();
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
		list.getFirst();
		list.getLast();
		list.removeFirst();
		list.removeLast();

	}

}
