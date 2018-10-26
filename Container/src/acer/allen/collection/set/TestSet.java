package acer.allen.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * // 面向接口 Set<Integer> set = new HashSet<Integer>(123); set.add(3);
		 * set.add(123); set.add(4); set.add(125); set.add(23); set.add(323);
		 * System.err.println("----------原来元素---------------------");
		 * System.out.println(set.size()); System.out.println(set);
		 * set.remove(123);
		 * System.err.println("----------删除123之后-----------------");
		 * System.out.println(set.size()); System.out.println(set);
		 * System.out.println("-------foreach----------------------"); //
		 * 遍历只能使用迭代器 Iterator 和 foreach（底层也是迭代器） for (Integer integer : set) {
		 * System.out.print(integer + "--"); } // 迭代器
		 * System.out.println("\n-------iterator----------------------");
		 * Iterator<Integer> iterator = set.iterator(); while
		 * (iterator.hasNext()) { System.out.print(iterator.next() + "--");
		 * 
		 * }
		 */
		Set<Student> set=new HashSet<>();
		set.add(new Student("Alex", 0, 0));
		for (int i = 0; i < 4; i++) {
			set.add(new Student("Alex", i*5, i*30.5));
		}
		 System.err.println("-------foreach----------------------"); 
		 for (Student student : set) {
			System.out.println(student);
		}
		 System.err.println("\n-------Iterator------------------");
		 Iterator<Student> it=set.iterator();
		 while(it.hasNext()){
			Student stu=it.next();
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
