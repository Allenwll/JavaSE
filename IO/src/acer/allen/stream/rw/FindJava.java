package acer.allen.stream.rw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FindJava {
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	public static void main(String[] args) throws IOException {
		File file = new File("d:/sxtjava");
		if (!file.isDirectory()) {
			System.err.println("不是正确的目录！");
			return;
		}
		findFile(file);
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/java.txt"));
		bw.write(sb.toString());
		bw.close();
		System.out.printf("已经写了%d行代码。", count);

	}

	static void findFile(File f) throws IOException {
		File[] fileList = f.listFiles();
		for (File file : fileList) {
			if (!file.isFile())
				findFile(file);
			if (file.isFile() && file.getAbsolutePath().endsWith(".java")) {
				copy(file);
			}
		}
	}

	static void copy(File file) throws IOException {
		br = new BufferedReader(new FileReader(file));
		String str = null;
		while (true) {
			str = br.readLine();
			if (str == null) {
				break;
			}
			sb.append(str);
			count++;
		}
		br.close();
	}

}
