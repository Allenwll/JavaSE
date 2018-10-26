package ChangeList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Map���ϵ�List����
 * 
 * @author acer
 *
 */
public class MapToList {

	// ��̬�ֶ�
	static Map<Integer, Student> map;

	/**
	 * �������
	 * 
	 * @param args
	 * 
	 */

	public static void main(String[] args) {

		// ʵ����
		Map<Integer, Student> map = new TreeMap<Integer, Student>();

		// �������
		Student stu = new Student(4, "Hige", 19, "��");
		map.put(stu.getId(), stu);
		stu = new Student(5, "Add", 18, "��");
		map.put(stu.getId(), stu);
		stu = new Student(6, "July", 19, "Ů");
		map.put(stu.getId(), stu);

		// ����ת������
		mapToList(map);

	}

	/**
	 * MapתList����
	 * 
	 * @param map
	 */
	private static void mapToList(Map<Integer, Student> map) {

		// ʵ����
		List<StudentEntry> linkList = new LinkedList<StudentEntry>();

		// ��ʼ����
		Set<Entry<Integer, Student>> set = map.entrySet();

		// �õ�������
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

		System.err.println("---------------------����List-------------");
		// ѭ������
		for (StudentEntry entry : linkList) {
			System.out.println(entry);
		}

	}
}

/**
 * StudentEntry ��
 * 
 * @author acer
 *
 */
class StudentEntry {

	// ��
	private int key;

	// ֵ
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