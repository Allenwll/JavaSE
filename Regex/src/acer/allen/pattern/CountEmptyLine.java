package acer.allen.pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ͳ�ƿհ���
 * 
 * @author acer
 *
 */
public class CountEmptyLine {

	public static void main(String[] args) throws IOException {

		// �ַ���ȡ������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./Test.java"))));

		String len = br.readLine();
		// �հ��ַ���ͷ �հ׽�β "^\\s*$"
		Pattern p = Pattern.compile("^\\s*$");

		int count = 0;

		while (len != null) {

			Matcher m = p.matcher(len);

			while (m.find()) {

				System.out.println(m.group());

				count++;
			}

			len = br.readLine();
		}

		System.out.println("�հ�����:" + count);

		br.close();
	}

}
