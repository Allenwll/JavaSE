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
			System.out.println("������һ������:");
			s = br.readLine();
			System.out.println("s= " + Integer.parseInt(s));

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e)// ��Ӧ�ó�����ͼ���ַ���ת����һ����ֵ���ͣ������ַ�������ת��Ϊ�ʵ���ʽʱ���׳����쳣��
		{
			System.err.println(" ����Ĳ�������. ");
		}
	}

	static void receive() throws IOException {
		String s = null;
		StringBuilder sb=new StringBuilder();
		InputStreamReader re = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(re);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("5.txt")));
		System.out.println("����������(����exit��������):");
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
