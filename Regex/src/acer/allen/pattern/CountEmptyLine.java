package acer.allen.pattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统计空白行
 * 
 * @author acer
 *
 */
public class CountEmptyLine {

	public static void main(String[] args) throws IOException {

		// 字符读取缓冲区
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("./Test.java"))));

		String len = br.readLine();
		// 空白字符开头 空白结尾 "^\\s*$"
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

		System.out.println("空白行有:" + count);

		br.close();
	}

}
