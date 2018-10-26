package acer.allen.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestByteArray {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// 基本数据类型互转
		test();
		// 引用数据类型 (类类型)
		test1();
	}

	static void test() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		// 基本数据类型
		dos.writeByte(1);
		dos.writeShort(2);
		dos.writeInt(3);
		dos.writeLong(546551212L);
		dos.writeFloat(3.25f);
		dos.writeDouble(5.26d);
		dos.writeBoolean(true);
		dos.writeChar('a');
		// 字符串
		dos.writeUTF("Allen");
		byte[] temp = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(temp);
		DataInputStream dis = new DataInputStream(bais);
		System.out.println(dis.readByte());
		System.out.println(dis.readShort());
		System.out.println(dis.readInt());
		System.out.println(dis.readLong());
		System.out.println(dis.readFloat());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
	}

	static void test1() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(new People(15, "Mars"));
		byte[] temp = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(temp);
		ObjectInputStream ois = new ObjectInputStream(bais);
		People p = (People) ois.readObject();
		System.out.println(p);
	}
}

class People implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	private String name;

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

	public People(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "People 年龄=" + age + ", 姓名=" + name;
	}

}
