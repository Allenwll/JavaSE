package ChangeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * List����ת����Map
 * 
 * @author acer
 *
 */
public class ListToMap {

	// ���徲̬map
	static Map<Integer, Student> map;

	/**
	 * �������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// ʵ����list����
		List<Student> list = new ArrayList<Student>();

		// ʵ����map
		map = new HashMap<Integer, Student>();

		// �������
		list.add(new Student(1, "Mars", 18, "��"));
		list.add(new Student(2, "Mark", 18, "��"));
		list.add(new Student(3, "Mary", 19, "Ů"));

		// ��ʾ
		System.err.println("----------------����List---------------------------");

		// �õ�������
		Iterator<Student> it = list.iterator();

		// ��ʼ����
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// ����ת������
		listToMap(list);

	}

	/**
	 * list����ת����Map����
	 * 
	 * @param list
	 */
	public static void listToMap(List<Student> list) {

		// ��ʾ
		System.out.println("----------List�е�����ת����Map-------------");

		// ��ʼת��
		for (int i = 0; i < list.size(); i++) {
			Student stu = list.get(i);
			map.put(stu.getId(), stu);
		}

		// ��ʾ
		System.out.println("----------------����Map------------------------");

		// ��ʼ����Map
		Set<Entry<Integer, Student>> set = map.entrySet();
		Iterator<Entry<Integer, Student>> it = set.iterator();
		while (it.hasNext()) {
			Entry<Integer, Student> entry = it.next();
			System.out.println("key:" + entry.getKey() + "\tValue:" + entry.getValue());
		}
	}

}

/**
 * ѧ����
 * 
 * @author acer
 *
 */
class Student {

	// ѧ��
	private int id;

	// ����
	private String name;

	// ����
	private int age;

	// �Ա�
	private String sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	public Student(int id, String name, int age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

}
