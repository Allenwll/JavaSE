package acer.allen.collection.set.hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
public class TestLinkedHashSet {
	public static void main(String[] args) {
		LinkedHashSet<Integer> set1 = new LinkedHashSet<>(123);

		// ����ӿ�
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
		System.err.println("----------ԭ��Ԫ��---------------------");
		System.out.println(set.size());
		System.out.println(set);
		set.remove(123);
		System.err.println("----------ɾ��123֮��-----------------");
		System.out.println(set.size());
		System.out.println(set);
		System.out.println("-------foreach----------------------");
		// ����ֻ��ʹ�õ����� Iterator �� foreach���ײ�Ҳ�ǵ�������
		for (Integer integer : set) {
			System.out.print(integer + "--");
		} // ������
		System.out.println("\n-------iterator----------------------");

		java.util.Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "--");

		}
	}

}
