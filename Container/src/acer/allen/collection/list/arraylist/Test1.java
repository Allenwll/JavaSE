package acer.allen.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Test1 {
	// ʵ�����ַ���
	static StringBuilder sb = new StringBuilder();

	// ʵ���������б�
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		// ���Ԫ��
		addElements();
		// ��ӡ
		showArrayList();
		// ɾ����ͬԪ��
		removeSameElements(list);
		// ȥ�հ�
		list.trimToSize();
		/*
		 * Object[] o = list.toArray(); System.out.println((String) o[0]);
		 */
	}

	/**
	 * ��������ַ���
	 * 
	 * @param sb
	 *            �ɱ��ַ����� ���̰߳�ȫ
	 * @return �����ַ���
	 */
	@SuppressWarnings("unused")
	static String getString(StringBuilder sb) {
		String s = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
		// �����ʵ����
		Random random = new Random();
		// ѭ���õ�����ַ�
		for (int j = 0; j < s.length(); j++) {
			int r = random.nextInt(s.length());
			sb.append(s.charAt(r));
			break;
		}
		return sb.toString();
	}

	/**
	 * ��������б�Ԫ��
	 * 
	 */
	static void addElements() {
		// ѭ���������
		for (int i = 0; i < 50; i++) {
			list.add(getString(sb));
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	/**
	 * ɾ����ͬ��Ԫ��
	 */
	static void removeSameElements(ArrayList<String> list) {
		System.err.println("\nԭ��������Ϊ:\n\n" + list);
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				String temp = list.get(j);
				if (s.equals(temp)) {
					list.remove(j);
					j--;
				}
			}
		}
		System.err.println("\nɾ���ظ�Ԫ�غ������Ϊ��\n\n" + list);
	}

	/**
	 * ��ӡ�����б�Ԫ��
	 */
	static void showArrayList() {

		System.err.println("-----------------------------------��������1��-------------------------\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("��%d��������%s\n", i + 1, list.get(i));
		}
		System.err.println("-----------------------------------��������2��-------------------------\n");
		int i = 0;
		for (String string : list) {
			System.out.printf("��%d��������%s\n", i + 1, string);
			i++;
		}
		System.err.println("-----------------------------------��������3��-------------------------\n");
		// ʵ����������
		Iterator<String> it = list.iterator();
		i = 0;
		// ѭ������Ϊ �α��Ƿ����ҵ���һ������
		while (it.hasNext()) {
			// �ҵ��� ��ӡ�α��ҵ�������
			System.out.printf("��%d��Ԫ����%s\n", i + 1, it.next());
			i++;

		}
	}

}
