package ChangeList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Map集合到List集合
 * 
 * @author acer
 *
 */
public class MapToList {

	// 静态字段
	static Map<Integer, Student> map;

	/**
	 * 程序入口
	 * 
	 * @param args
	 * 
	 */

	public static void main(String[] args) {

		// 实例化
		Map<Integer, Student> map = new TreeMap<Integer, Student>();

		// 添加数据
		Student stu = new Student(4, "Hige", 19, "男");
		map.put(stu.getId(), stu);
		stu = new Student(5, "Add", 18, "男");
		map.put(stu.getId(), stu);
		stu = new Student(6, "July", 19, "女");
		map.put(stu.getId(), stu);

		// 调用转换方法
		mapToList(map);

	}

	/**
	 * Map转List方法
	 * 
	 * @param map
	 */
	private static void mapToList(Map<Integer, Student> map) {

		// 实例化
		List<StudentEntry> linkList = new LinkedList<StudentEntry>();

		// 开始遍历
		Set<Entry<Integer, Student>> set = map.entrySet();

		// 得到迭代器
		Iterator<Entry<Integer, Student>> ientry = set.iterator();

		while (ientry.hasNext()) {
			StudentEntry en = new StudentEntry();
			Entry<Integer, Student> entry = ientry.next();
			int key = entry.getKey();
			Student student = entry.getValue();
			en.setKey(key);
			en.setValue(student);
			linkList.add(en);
		}

		System.err.println("---------------------遍历List-------------");
		// 循环遍历
		for (StudentEntry entry : linkList) {
			System.out.println(entry);
		}

	}
}

/**
 * StudentEntry 类
 * 
 * @author acer
 *
 */
class StudentEntry {

	// 键
	private int key;

	// 值
	private Student value;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Student getValue() {
		return value;
	}

	public void setValue(Student value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "StudentEntry [key=" + key + ", value=" + value.toString() + "]";
	}

	public StudentEntry(int key, Student value) {
		super();
		this.key = key;
		this.value = value;
	}

	public StudentEntry() {

	}
}