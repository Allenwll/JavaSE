package acer.allen.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Allen
 * 
 *  HashMap  key value  键值对  映射 
 *    
 *    key 无序 唯一  底层用哈希表实现   一个顺序表加一个链表实现 
 *   
 *  Hashtable 是 key-value模式的早期版本
 *  
 *   继承Dictionary类	 效率低 线程安全  不允许存储null	
 * 
 *  TreeMap  
 *    
 *    key 有序 唯一 底层用二叉树实现 
 *    
 */

public class TestHashMap {

	public static void main(String[] args) {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "Mars", 17, 88.1));
		map.put(2, new Student(2, "Andy", 15, 98.1));
		map.put(1, new Student(3, "Alex", 23, 100));
		map.put(3, new Student(4, "Ande", 31, 59.5));
		map.put(4, new Student(5, "Mark", 19, 78.1));
		System.out.println(map);
		System.err.println("-----------遍历1----------------");
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			Student value = map.get(key);
			System.out.println(value);
		}

		System.err.println("-----------遍历2----------------");
		Collection<Student> stu = map.values();
		for (Student student : stu) {
			System.out.println(student);
		}
		System.err.println("--------遍历3--------------------");
		Set<Entry<Integer, Student>> setEntry = map.entrySet();
		Iterator<Entry<Integer, Student>> itEntry = setEntry.iterator();
			while(itEntry.hasNext()){
					Entry<Integer,Student> entry=itEntry.next();
					System.out.print(entry.getKey()+"---");
					System.out.print(entry.getValue()+"\n");
			}
	}

}

class Student {
	private int id;
	private String name;
	private int age;
	private double score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]\n";
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Student(int id, String name, int age, double score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;

	}

}