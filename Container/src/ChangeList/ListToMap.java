package ChangeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * List集合转换成Map
 * 
 * @author acer
 *
 */
public class ListToMap {

	// 定义静态map
	static Map<Integer, Student> map;

	/**
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 实例化list集合
		List<Student> list = new ArrayList<Student>();

		// 实例化map
		map = new HashMap<Integer, Student>();

		// 添加数据
		list.add(new Student(1, "Mars", 18, "男"));
		list.add(new Student(2, "Mark", 18, "男"));
		list.add(new Student(3, "Mary", 19, "女"));

		// 提示
		System.err.println("----------------遍历List---------------------------");

		// 得到迭代器
		Iterator<Student> it = list.iterator();

		// 开始迭代
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// 调用转换方法
		listToMap(list);

	}

	/**
	 * list集合转换成Map方法
	 * 
	 * @param list
	 */
	public static void listToMap(List<Student> list) {

		// 提示
		System.out.println("----------List中的数据转换到Map-------------");

		// 开始转换
		for (int i = 0; i < list.size(); i++) {
			Student stu = list.get(i);
			map.put(stu.getId(), stu);
		}

		// 提示
		System.out.println("----------------遍历Map------------------------");

		// 开始遍历Map
		Set<Entry<Integer, Student>> set = map.entrySet();
		Iterator<Entry<Integer, Student>> it = set.iterator();
		while (it.hasNext()) {
			Entry<Integer, Student> entry = it.next();
			System.out.println("key:" + entry.getKey() + "\tValue:" + entry.getValue());
		}
	}

}

/**
 * 学生类
 * 
 * @author acer
 *
 */
class Student {

	// 学号
	private int id;

	// 姓名
	private String name;

	// 年龄
	private int age;

	// 性别
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
