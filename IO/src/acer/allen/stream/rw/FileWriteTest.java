package acer.allen.stream.rw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
	public static void main(String[] args) throws IOException {
		copyFile();

	}

	static void writerFile() throws IOException {
		FileWriter fw = new FileWriter("./1.txt", true);
		String s = "\n���ʹ���δ���ڣ��������ӻ��˼�\n ��������������,��ʽ��̢���ȱ�\nС¥��ҹ�ֶ��磬����ţ������\n"
				+ "������ֻ�����,��̳���ţ����\n����������ѻ,�յ�WIFI����\nһ�����һ���,�ϰ�����������";
		// fw.write(s);
		fw.append(s);
		fw.append(s);
		fw.flush();
		fw.close();

	}

	static void copyFile() throws IOException {
		FileReader fr = new FileReader("./1.txt");
		FileWriter fw = new FileWriter("C:\\Users\\acer\\Desktop\\2.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		while (true) {
			String len = br.readLine();
			if (len == null) {
				break;
			}
			bw.write(len);
		}
		br.close();
		fr.close();
		bw.close();
		fw.close();
	}
}
