package acer.allen.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TestTreeMap {
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("cn", "China");
		map.put("us", "The U.S.A");
		map.put("uk", "The U.K");
		map.put("jp", "Japan");

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		System.err.println("\n-----------±éÀú1----------------\n");
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + "-----------" + value);
		}
		System.err.println("\n-----------±éÀú2----------------\n");
		Collection<String> collection = map.values();
		for (String string : collection) {
			System.out.println("value-----------------------" + string);
		}
		System.err.println("\n-----------±éÀú3----------------\n");
		Set<Entry<String, String>> setEntry = map.entrySet();
		Iterator<Entry<String, String>> itEntry = setEntry.iterator();
		while (itEntry.hasNext()) {
			Entry<String, String> entry = itEntry.next();
			System.out.print(entry.getKey() + "---");
			System.out.print(entry.getValue() + "\n");
		}
	}
}
