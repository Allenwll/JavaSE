package acer.allen.stream.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

public class InputStreamRead {
	public static void main(String[] args) throws IOException {
		receive();
	}

	static void readNum() {
		String s = null;
		InputStreamReader re = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(re);
		try {
			System.out.println("请输入一个整数:");
			s = br.readLine();
			System.out.println("s= " + Integer.parseInt(s));

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e)// 当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常。
		{
			System.err.println(" 输入的不是数字. ");
		}
	}

	static void receive() throws IOException {
		String s = null;
		StringBuilder sb=new StringBuilder();
		InputStreamReader re = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(re);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("5.txt")));
		System.out.println("请输入数据(输入exit结束输入):");
		s = br.readLine();
		while (!s.equals("exit")) {
			bw.write(s);
			bw.newLine();
			sb.append(s+"\n");
			s = br.readLine();
		}
		System.out.println(sb.toString());
		bw.close();
		br.close();
		re.close();

	}
}
