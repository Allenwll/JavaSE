package acer.allen.collection.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import acer.allen.collection.Person;

public class TestVector {
	// ���ͳ��� LEN
	final static int LEN = 5;
	static Person p;
	// ���� �̰߳�ȫ������ �ײ�������ʵ�� Ч�ʵ�
	static List<Person> vector = new Vector<Person>();
	// ����洢
	static List<Person> list = new LinkedList<Person>();
	// ʵ���������
	static Random random = new Random();

	public static void main(String[] args) {
		// ���ó�ʼ��
		init(vector);
		// ��ӡԪ��
		showElements(vector);
		// ���ó�ʼ��
		init(list);
		System.err.println("----------------------------------");
		// ��ӡԪ��
		showElements(list);
	}

	/**
	 * �������5������
	 * 
	 * @return �������������
	 */
	static void init(List<Person> list) {
		for (int i = 0; i < LEN; i++) {
			p = new Person();
			list.add(p);
		}

	}

	/**
	 * ��ӡԪ��
	 */
	static void showElements(List<Person> list) {
		ListIterator<Person> it = list.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
