package acer.allen.stream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestPrintStream {
	public static void main(String[] args) throws IOException {
		test();
		receive();
	}

	static void test() throws IOException {
		PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("4.txt")), true);
		ps.println("\t\t\t������");
		ps.println(true);
		ps.println("\t\t���������ƺ�֮ˮ��������\n");
		ps.println("\t�������������أ�\n");
		ps.println("\t\t�������������������׷���\n");
		ps.println("\t������˿ĺ��ѩ��\n");
		ps.println("\t\t���������뾡����Īʹ���׿ն���\n");
		ps.println("\t\t�����Ҳı����ã�ǧ��ɢ��������\n");
		ps.println(new Student(18, "���"));
		ps.close();
	}
	//PrintWriter �ַ���ӡ��  
	static void receive() throws IOException {
		String s = null;
		InputStreamReader re = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(re);
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("3.txt")));
		System.out.println("����������(����exit��������):");
		s = br.readLine();
		while (!s.equals("exit")) {
			pw.println(s);
			s = br.readLine();
		}
		pw.close();
		br.close();
		re.close();

	}
}

class Student {
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

	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "\t����:" + age + "\t����:" + name;
	}

}