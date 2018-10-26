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
 * @version 创建时间：2016年8月19日 下午5:55:29
 * 
 *          类说明： 输入一个字符串, 统计 出现的个数
 */
public class CountLetter {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一串字符!");
		String str = sc.nextLine();
		// count方法
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
	 * 统计
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
