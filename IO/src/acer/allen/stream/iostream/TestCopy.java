package acer.allen.stream.iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestCopy {
	public static void main(String[] args) throws Exception {
		// ���û��帴��
		bufferedCopy();
		// ����char���鸴��
		charArrayCopy();
	}

	static void bufferedCopy() throws IOException {
		// д��
		FileReader fr = new FileReader("./1.txt");
		// ����д��
		BufferedReader br = new BufferedReader(fr);
		// д��
		FileWriter fw = new FileWriter("2.txt");
		// ����д��
		BufferedWriter bw = new BufferedWriter(fw);
		// �����ļ�
		while (true) {
			// ���ж�ȡ
			String len = br.readLine();
			if (len == null) {
				break;
			}
			// д��
			bw.write(len+"\n");
		}
		// �ر���
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
			// �ַ����ݵ���תվ
			char[] temp = new char[6];
			// ���ζ�ȡ�ַ��ĸ���
			int len = fr.read(temp);
			while (len != -1) {
				// ������������д��ָ�����ļ�
				fw.write(temp, 0, len);
				// ������ȡ����������
				len = fr.read(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر���
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
