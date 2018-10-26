package acer.allen.stream.iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCopy {
	public static void main(String[] args) throws Exception {
		// 利用缓冲复制
		bufferedCopy();
		// 利用char数组复制
		charArrayCopy();
	}

	static void bufferedCopy() throws IOException {
		// 写入
		FileReader fr = new FileReader("./1.txt");
		// 缓存写入
		BufferedReader br = new BufferedReader(fr);
		// 写出
		FileWriter fw = new FileWriter("2.txt");
		// 缓存写出
		BufferedWriter bw = new BufferedWriter(fw);
		// 复制文件
		while (true) {
			// 按行读取
			String len = br.readLine();
			if (len == null) {
				break;
			}
			// 写入
			bw.write(len+"\n");
		}
		// 关闭流
		bw.close();
		br.close();
		fr.close();
		fw.close();
	}

	static void charArrayCopy() {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("1.txt");
			fw = new FileWriter("3.txt");
			// 字符数据的中转站
			char[] temp = new char[6];
			// 单次读取字符的个数
			int len = fr.read(temp);
			while (len != -1) {
				// 将读到的内容写到指定的文件
				fw.write(temp, 0, len);
				// 继续读取后续的内容
				len = fr.read(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			try {
				if (fw != null) {
					fw.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
