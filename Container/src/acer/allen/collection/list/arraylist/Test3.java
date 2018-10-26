package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Test3 {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		// ʵ����
		ArrayList<String> list = new ArrayList<String>();
		// �������Ԫ�ط���
		addElements(list);
		// ��ӡ
		System.err.println("-------------------ԭ����Ԫ��-------------------------\n");
		showElements(list);
		// ���������Ԫ�ط���
		addNewElements(list);
		System.err.println("\n-------------------�޸ĺ��Ԫ��------------------------\n");
		showElements(list);
	}

	/**
	 * �������ڵ�Ԫ����ͬ�������Ԫ��
	 */
	static void addNewElements(ArrayList<String> list) {
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			String str = it.next();
			int index = it.previousIndex();
			// ��������һ��Ԫ�� ����ѭ��
			if (index == (list.size() - 1)) {
				break;
			}
			String perStr = list.get(index+1);
			if (perStr.equals(str)) {
				it.add(str.toLowerCase());
			}

		}

	}
	/**
	 * �������ڵ�Ԫ����ͬ�������Ԫ��
	 */
	static void addNewElement(ArrayList<String> list) {
		ListIterator<String> it = list.listIterator();
		while (it.hasNext()) {
			String str = it.next();
			int index = it.previousIndex();
			// ��������һ��Ԫ�� ����ѭ��
			if (index == (list.size() - 1)) {
				break;
			}
			String perStr = list.get(index);
			String nextStr=list.get(index+1);
			if (perStr.equals(nextStr)) {
				it.add(str.toLowerCase());
			}

		}

	}

	/**
	 * ���Ԫ��
	 * 
	 * @param list
	 *            �ַ������б�
	 */
	private static void addElements(ArrayList<String> list) {
		for (int i = 0; i < 20; i++) {
			list.add(getStringNum(sb));
			sb.deleteCharAt(sb.length() - 1);

		}
	}

	/**
	 * �õ������
	 */
	static String getStringNum(StringBuffer sb) {
		String s = "ABCDEF";

		// ʵ���������
		Random random = new Random();
		// �õ������
		int i = random.nextInt(s.length());
		sb.append(s.charAt(i));
		return sb.toString();
	}

	/**
	 * ��ӡԪ��
	 * 
	 */
	static void showElements(ArrayList<String> list) {
		for (String str : list) {
			System.out.print(" " + str);
		}
	}
}
