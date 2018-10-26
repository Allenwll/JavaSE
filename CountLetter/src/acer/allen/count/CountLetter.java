package acer.allen.count;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Allen Wang
 * 
 * @Email 1303542271@qq.com
 *
 * @version ����ʱ�䣺2016��8��19�� ����5:55:29
 * 
 *          ��˵���� ����һ���ַ���, ͳ�� ���ֵĸ���
 */
public class CountLetter {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�!");
		String str = sc.nextLine();
		// count����
		HashMap<String, Integer> map = (HashMap<String, Integer>) count(str);

		Set<Entry<String, Integer>> set = map.entrySet();
		
		Iterator<Entry<String, Integer>> it = set.iterator();

		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.print("key-------------" + entry.getKey());
			System.out.println("\tvalue-----------" + entry.getValue());
		}

	}

	/**
	 * ͳ��
	 */
	private static Map<String, Integer> count(String str) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < str.length(); i++) {
			String key = str.substring(i, i + 1);
			Integer value = map.get(key);
			if (value == null)
				map.put(key, 1);
			else
				map.put(key, value + 1);
		}

		return map;

	}
}
