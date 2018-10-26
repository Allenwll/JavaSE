package acer.allen.pattern;

import java.util.Scanner;

/**
 * 统计字符的个数 1输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
 * 
 * @author acer
 *
 */
public class Test2 {

	public static void main(String[] args) {

		// 输入
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("请输入一行字符：");

		String str = s.nextLine();// 接收数字

		// 正则
		String E1 = "[\u4e00-\u9fa5]";// 汉字
		String E2 = "[a-zA-Z]";// 字母
		String E3 = "[0-9]";// 数字
		String E4 = "\\s";// 空格

		// 计数
		int couChinese = 0;
		int couLetter = 0;
		int coutNumber = 0;
		int couSpace = 0;
		int couOther = 0;

		char[] array_char = str.toCharArray();// 转成字符数组

		String[] array_str = new String[array_char.length];// 转成字符串数组

		// 遍历赋值
		for (int i = 0; i < array_str.length; i++) {
			array_str[i] = String.valueOf(array_char[i]);
		}

		for (String string : array_str) {
			if (string.matches(E1))
				couChinese++;
			else if (string.matches(E2))
				couLetter++;
			else if (string.matches(E3))
				coutNumber++;
			else if (string.matches(E4))
				couSpace++;
			else
				couOther++;
		}

		System.out.println("你输入的字符串统计的结果为:");
		System.out.println("中文字符:" + couChinese + "个");
		System.out.println("英文字符:" + couLetter + "个");
		System.out.println("数字字符:" + coutNumber + "个");
		System.out.println("空白字符:" + couSpace + "个");
		System.out.println("其他字符:" + couOther + "个");

	}

}
