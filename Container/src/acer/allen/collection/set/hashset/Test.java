package acer.allen.collection.set.hashset;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * 
 * @author Allen
 * 
 *  HashSet  增删改查快 
 *   
 *   元素唯一   元素无序
 *   
 *   底层用哈希表实现  一个顺序表加链表
 *  
 *  LinkedHashSet 元素唯一  有序
 *   
 *   哈希表加维护顺序的链表
 *   
 *   比hashSet效率低一些 查找删除效率相对慢了一些 但还是比List要快
 *   
 *  
 *  TreeSet 元素唯一（实现hashCode和equals方法）  升序排列 有序
 *					
 *	底层用二叉树实现   遍历 递归
 *						
 *	查找，修改 没有hashSet 快 但比List快
 *  
 *
 */
public class Test {  
	public static void main(String[] args) {
		Set<Student> set = new LinkedHashSet<>();
		set.add(new Student("Alex", 0, 0));
		for (int i = 0; i < 4; i++) {
			set.add(new Student("Alex", i * 5, i * 30.5));
		}
		System.err.println("-------foreach----------------------");
		for (Student student : set) {
			System.out.println(student);
		}
		System.err.println("\n-------Iterator------------------");
		Iterator<Student> it = set.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			System.out.println(stu);
		}
	}
}

class Student {
	private String name;
	private int age;
	private double score;

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

	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}
}