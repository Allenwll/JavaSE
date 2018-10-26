package acer.allen.collection.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import acer.allen.collection.Person;

public class TestVector {
	// 整型常量 LEN
	final static int LEN = 5;
	static Person p;
	// 向量 线程安全的容器 底层用数组实现 效率低
	static List<Person> vector = new Vector<Person>();
	// 链表存储
	static List<Person> list = new LinkedList<Person>();
	// 实例化随机数
	static Random random = new Random();

	public static void main(String[] args) {
		// 调用初始化
		init(vector);
		// 打印元素
		showElements(vector);
		// 调用初始化
		init(list);
		System.err.println("----------------------------------");
		// 打印元素
		showElements(list);
	}

	/**
	 * 生成随机5个对象
	 * 
	 * @return 返回类数组对象
	 */
	static void init(List<Person> list) {
		for (int i = 0; i < LEN; i++) {
			p = new Person();
			list.add(p);
		}

	}

	/**
	 * 打印元素
	 */
	static void showElements(List<Person> list) {
		ListIterator<Person> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
