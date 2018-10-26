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
		ps.println("\t\t\t将近酒");
		ps.println(true);
		ps.println("\t\t君不见，黄河之水天上来。\n");
		ps.println("\t奔流到海不复回！\n");
		ps.println("\t\t君不见，高堂明镜悲白发。\n");
		ps.println("\t朝如青丝暮成雪！\n");
		ps.println("\t\t人生得意须尽欢，莫使金樽空对月\n");
		ps.println("\t\t天生我材必有用，千金散尽还复来\n");
		ps.println(new Student(18, "李白"));
		ps.close();
	}
	//PrintWriter 字符打印流  
	static void receive() throws IOException {
		String s = null;
		InputStreamReader re = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(re);
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream("3.txt")));
		System.out.println("请输入数据(输入exit结束输入):");
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
		return "\t年龄:" + age + "\t作者:" + name;
	}

}