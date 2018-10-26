package acer.allen.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestOIS {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		test();
		test1();
	}

	static void test() throws FileNotFoundException, IOException {
		// 对象的序列化
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("7.txt"));
		oos.writeObject(new NewStudent(23, "Mars"));
		oos.close();
	}

	static void test1() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("7.txt"));
		NewStudent stu = (NewStudent) ois.readObject();
		System.out.println(stu);
		ois.close();
	}
}

class NewStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	//被 static和transient 修饰的不被序列化
	private transient String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NewStudent(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "\t年龄:" + age + "\t姓名:" + name;
	}

}