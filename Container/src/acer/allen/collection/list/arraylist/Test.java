package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// <> ����
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
		 * list.clear();��� list.contains(o); �Ƿ���� list.indexOf(o); ��������ֵ
		 * list.isEmpty(); �Ƿ�Ϊ��
		 */
		System.err.println("\n��������1-----------------------\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.err.println("\n��������2-----------------------\n");

		for (Object object : list) {
			System.out.println(object);
		}
		System.err.println("\n�ⲿ������-----------------------\n");
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}
	}
}
