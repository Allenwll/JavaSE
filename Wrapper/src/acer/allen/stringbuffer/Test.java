package acer.allen.stringbuffer;

import java.util.Random;

public class Test {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		 
		sb=getRandomString(30);
		
		// 打印sb信息
		showSb(sb);
		
		//删除sb中的大写字母
		System.out.println("\n去掉字符串缓冲区内的大写字母以后：\n");
		delUpperCase(sb);
		
		//打印sb信息
		showSb(sb);
		
		//调用trimToSize方法
		System.out.println("\n去掉字符串缓冲区内的空格以后：\n");
		sb.trimToSize();
		
		//打印sb信息
		showSb(sb);
	}

	/**
	 * 定义一个方法用于得到随机数字符
	 */

	public static StringBuffer getRandomString(int length) {
		// 定义一个字符串
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// 实例化一个随机数对象
		Random random = new Random();

		// 实例化一个字符串缓冲区

		for (int i = 0; i < length; i++) {

			// 定义一个number 存储得到的随机的索引
			int number = random.nextInt(str.length());

			// 将该索引对应的str上的字符追加到字符串缓冲区
			sb.append(str.charAt(number));
		}
		return sb;
	}

	/**
	 * 显示sb的信息
	 * 
	 * @param sb
	 *            字符串缓冲区
	 */
	public static void showSb(StringBuffer sb) {
		System.out.println("字符串的容量为：" + sb.capacity());
		System.out.println("-----------------------------------------------------");
		System.out.println("字符串的长度是：" + sb.length());
		System.out.println("-----------------------------------------------------");
		System.out.println("字符串内容是：" +sb.toString());
		System.out.println("-----------------------------------------------------");
	}
	/**
	 * 删除sb中的大写字母
	 */
	public static void delUpperCase(StringBuffer sb){
		for (int i = 0; i < sb.length(); i++) {
			char c=sb.charAt(i);
			if(c>='A'&&c<='Z'){
				sb.deleteCharAt(i);
				i--;
			}
		}
	}
}
