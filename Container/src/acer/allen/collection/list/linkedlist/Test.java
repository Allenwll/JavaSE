package acer.allen.collection.list.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author Allen
 * 
 * ArrayList Ԫ�ز�Ψһ  ����
 * 
 *   �ײ�������ʵ��  �̲߳���ȫ  ��ѯ��  ��ɾ����
 *   
 * Vector  Ԫ�ز�Ψһ ����
 * 
 *   �̰߳�ȫ    Ч�ʱ�ArrayList��  
 *  
 * LinkedList  Ԫ�ز�Ψһ  ����
 * 
 *   �ײ�������ʵ��  �ڴ治����  ��ɾ�Ŀ�  ��ѯ��
 *
 */
public class Test {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// <> ����
		List<String> lists = new ArrayList<String>(); // ����ӿڱ��
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
