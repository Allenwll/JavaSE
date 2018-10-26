package acer.allen.string;

import java.util.Arrays;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// 整型常量 LEN长度为20
		final int LEN = 20;

		// 定义字符数组
		char[] c = new char[LEN];

		// 控制循环
		int count = 0;

		// 对字符数组进行赋值
		while (count < LEN) {

			// 通过得到的整型结果进行判断
			int result = getMyChar();

			if (result > 0) {

				// 遍历赋值数组每个元素
				c[count] = (char) result;

				// 迭代
				count++;
			}
		}
		// 自动进行字符数组转换成为字符串
		String str = new String(c);

		// 将转换后的字符串打印：
		System.out.println("原来的字符串为:\n\t" + str);

		// 将原来的字符串 进行大小写转换：
		String newStr = getStr(str);

		// 将转换后的字符串打印：
		System.out.println("新字符串为:\n\t" + newStr);

		// 分别在索引为5,10,15,20处加入;
		newStr = insertStr(newStr, ";");

		// 将插入后的字符串打印：
		System.out.println("插入';'后的字符串为:\n\t" + newStr);

		// 用字符串数组存储截取后的字符串
		String[] stringNew = newStr.split(";");

		// 将字符串数组打印：
		System.out.println("展示新的字符串:\n\t" + Arrays.toString(stringNew));

		// 将数组的每个元素进行连接
		// String myString =
		// stringNew[0].concat(stringNew[1]).concat(stringNew[2]).concat(stringNew[3]);

		// 元素是否包含‘a’
		isElement(stringNew, 'a');
	}

	/**
	 * 得到随机字符 ['a'-'Z'] [65-122]
	 * 
	 * @return
	 */
	static int getMyChar() {

		// 得到差值 122 'z' 65 'A'
		int dis = 'z' - 'A' + 1;

		// 随机得到 'A'-'Z'中的随机值
		int random = (int) (Math.random() * dis) + 'A';
		/*
		 * // 如果得到的值在[A-Z]之间 if (random >= 'A' && random <= 'Z')
		 * 
		 * // 返回 ran return random;
		 * 
		 * // 如果得到的值在[a-z]之间 if (random >= 'a' && random <= 'z')
		 * 
		 * // 返回 ran return random;
		 * 
		 * // 上述情况都不满足则返回-1
		 */
		if (random > 'z' || random < 'a')
			return -1;
		return random;
	}

	/**
	 * 对str进行大小写转换
	 * 
	 * @param str
	 *            原字符串
	 * @return 新字符串
	 */
	static String getStr(String str) {
		// 得到字符的长度
		int len = str.length();

		// 定义一个临时字符串
		String tempStr = "";

		for (int i = 0; i < len; i++) {
			// 循环得到字符串中的每个字符并赋值给 字符c
			char c = str.charAt(i);
			// 如果c 在['A'-'Z']之间
			if (c >= 'A' && c <= 'Z')
				// 将c所对应的十进制数加32 得到其对应的小写字符
				c += 32;
			else {
				// 将c所对应的十进制数减32 得到其对应的大写字符
				c -= 32;
			}
			// 用+连接符将字符组合成一个字符串
			tempStr += c;

		}
		// 将该字符串返回
		return tempStr;
	}

	/**
	 * 在原字符串上的第5,10,15,20的索引上添加;
	 * 
	 * @param str
	 *            原字符串
	 * @param separator
	 *            添加的;字符
	 * @return 返回添加之后的字符串
	 */
	static String insertStr(String str, String separator) {
		// 定义临时的索引
		int index = 0;

		StringBuffer sb = new StringBuffer();
		/*
		 * String sub = str.substring(index, index + 5); index += 5; return
		 * sub.concat(separator) + sub1.concat(separator) +
		 * sub2.concat(separator) + sub3.concat(separator);
		 */
		sb.append(str.substring(index, index + 5) + separator);
		for (int i = 0; i < 3; i++) {
			index += 5;
			sb.append(str.substring(index, index + 5) + separator);
			if (index > 20)
				break;
		}
		return sb.toString();
	}

	static void isElement(String[] str, char c) {
		for (int i = 0; i < str.length; i++) {
			int len = str[i].length();
			for (int j = 0; j < len; j++) {
				char ch = str[i].charAt(j);
				if (ch == c) {
					System.out.println("\n包含字符[" + c + "]的元素有" + str[i]);
					break;
				}
			}
		}
	}

	/**
	 * 得到随机生成的一个字符串
	 * 
	 * @param length
	 *            字符串长度
	 * @return
	 */
	public static String getRandomString(int length) {
		// 定义一个字符串
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// 实例化一个随机数对象
		Random random = new Random();

		// 实例化一个字符串缓冲区
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++) {
			// 定义一个number 存储得到的随机的索引
			int number = random.nextInt(str.length());

			// 将该索引对应的str上的字符追加到字符串缓冲区
			sb.append(str.charAt(number));
		}
		// 返回字符串
		return sb.toString();
	}

}
