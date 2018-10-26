package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		// ʵ����
		ArrayList<Integer> list = new ArrayList<Integer>();
		// �������Ԫ�ط���
		addElements(list);
		// ��ӡ
		System.err.println("ԭ����--------------------------------------------\n");
		showElements(list);
		// ȥ������
		removeNum(list);
		// ��ӡ
		System.err.println("\n\nȥ������------------------------------------------\n");
		showElements(list);
	}

	/**
	 * ���Ԫ��
	 */
	static void addElements(ArrayList<Integer> list) {
		for (int i = 0; i < 20; i++) {
			list.add(getNum());
		}
	}

	/**
	 * �õ������
	 */
	static int getNum() {
		// ʵ���������
		Random random = new Random();
		// �õ������
		int i = random.nextInt(10);
		return i;
	}

	/**
	 * ȥ������
	 */
	static void removeNum(ArrayList<Integer> list) {
		ListIterator<Integer> it = list.listIterator();
		while (it.hasNext()) {
			Integer i = it.next();
			if (i % 2 == 1)
				it.remove();
		}
	}

	/**
	 * ��ӡԪ��
	 * 
	 */
	static void showElements(ArrayList<Integer> list) {
		for (Integer integer : list) {
			System.out.print(" " + integer);
		}
	}
}
