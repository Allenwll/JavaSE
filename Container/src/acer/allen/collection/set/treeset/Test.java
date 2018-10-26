package acer.allen.collection.set.treeset;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Test {

	public static void main(String[] args) {
		Set<Student> set = new TreeSet<Student>(new Comparator<Student>(){

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getAge()-o2.getAge();
			} 
		});
		set.add(new Student("Alex", 35, 95));
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

class Student implements Comparable<Student> {
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
	public int compareTo(Student o) {
		
		return this.age-o.age;
		//return ((Double)(this.score)).compareTo((Double)(o.score));
		//return this.name.compareTo(o.name);
	}
}
