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

	}
}
