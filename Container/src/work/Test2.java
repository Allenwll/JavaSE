package work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test2 {
	public static void main(String[] args) {

		List<Student> arrayList = new ArrayList<Student>();
		Map<Integer, Student> hashMap = new HashMap<>();
		System.err.println("\t\t功能1实现:\n");
		arrayList.add(new Student(1, "Mars", 17, "男"));
		arrayList.add(new Student(2, "Juli", 18, "女"));
		arrayList.add(new Student(3, "Alex", 23, "男"));
		arrayList.add(new Student(4, "Ande", 31, "男"));
		System.err.println("------------------------------遍历List---------------------------------------\n");
		Iterator<Student> it = arrayList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.err.println("\n-----------------------------遍历Map---------------------------------------\n");
		new Test2().listToMap(arrayList, hashMap);

		List<StuEntry> list = new ArrayList<>();
		Map<Integer, Student> map = new HashMap<>();
		System.err.println("\n\n\t\t功能2实现:\n");
		map.put(1, new Student(1, "A", 19, "男"));
		map.put(2, new Student(2, "B", 15, "女"));
		map.put(3, new Student(3, "C", 16, "男"));
		map.put(4, new Student(4, "D", 17, "女"));
		new Test2().mapToList(list, map);
	}

	public void listToMap(List<Student> list, Map<Integer, Student> map) {
		for (int i = 0; i < list.size(); i++) {
			map.put(i + 1, list.get(i));

		}
		Set<Entry<Integer, Student>> setEntry = map.entrySet();
		Iterator<Entry<Integer, Student>> itEntry = setEntry.iterator();
		while (itEntry.hasNext()) {
			Entry<Integer, Student> entry = itEntry.next();
			System.out.print(entry.getKey() + "---");
			System.out.print(entry.getValue() + "\n");
		}
	}

	public void mapToList(List<StuEntry> list, Map<Integer, Student> map) {
		Set<Entry<Integer, Student>> setEntry = map.entrySet();
		Iterator<Entry<Integer, Student>> itEntry = setEntry.iterator();
		while (itEntry.hasNext()) {
			Entry<Integer, Student> entry = itEntry.next();
			list.add(new StuEntry(entry.getKey(), entry.getValue()));
		}
		Iterator<StuEntry> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

class StuEntry implements Entry<Integer, Student> {
	private int key;
	private Student value;

	@Override
	public Integer getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public Student getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Student setValue(Student value) {
		// TODO Auto-generated method stub
		this.value = value;
		return value;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "StuEntry [key=" + key + ", value=" + value + "]";
	}

	public StuEntry(int key, Student value) {
		super();
		this.key = key;
		this.value = value;
	}

}
