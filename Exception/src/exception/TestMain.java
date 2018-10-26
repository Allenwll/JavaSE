package exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			loadRes();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner s = new Scanner(System.in);
		System.out.println("�����������");
		try {
			int score = s.nextInt();
			if (score < 0 || score > 100)
				throw new ScoreException();
		} catch (ScoreException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println("������������");
		}
	}

	static void loadRes() throws IOException {
		final int SIZE = 1024;
		String path = "D:/Allen/Java/Work/Test1.java";
		FileInputStream in = new FileInputStream(path);
		FileOutputStream out = new FileOutputStream("D:\\out.txt");
		byte[] buff = new byte[SIZE];
		int len = in.read(buff);
		while (len != -1) {
			// ��buff�е�����д��out.txt�ļ���
			out.write(buff, 0, len);
			// ���¶�ȡ����������ʱ�ѵ����������Ľ�β
			len = in.read();
		}
		in.close();
		out.close();
	}

}
