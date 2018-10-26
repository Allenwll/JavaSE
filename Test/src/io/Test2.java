package io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test2 {
	static List<Student> list = null;

	public static void main(String[] args) throws IOException {
		list = new ArrayList<Student>();
		input();
		write();

	}

	static void write() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("7.txt"));
		ListIterator<Student> lt = list.listIterator();
		while (lt.hasNext()) {
			Student s = lt.next();
			oos.writeObject(s);
			oos.writeUTF("\r\n");
			System.out.println(s);
		}
		oos.close();
	}

	static void input() throws IOException {
		InputStreamReader re = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(re);
		System.out.println("请输入您要输入的学生的数量：");
		String temp = br.readLine();
		int num=Integer.parseInt(temp);
		System.out.println("请输入学生信息(输入exit结束输入):");
		System.out.println("学生信息格式如  20120305,Allen,18");
		int i = 0;
		try {
			String s = br.readLine();
			while (!s.equals("exit")) {
				s = br.readLine();
				String[] str = s.split(",");
				String str1 = str[0];
				int no = Integer.parseInt(str1);
				String name = str[1];
				String str2 = str[2];
				int age = Integer.parseInt(str2);
				list.add(new Student(no, name, age));
				i++;
				if (i == num) {
					System.out.println("已达到输入的学生数量！自动exit");
					break;
				}
			}

		} catch (Exception e) {
		} finally {
			br.close();
			re.close();
		}
	}
}

class Student implements Comparable<Student>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6167533074368884969L;
	private int no;
	private String name;
	private int age;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public Student(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.getAge() - o.getAge();
	}

}
