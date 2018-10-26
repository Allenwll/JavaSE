package acer.allen.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
	/**
	 * .代表任意字符 split中不能使用 \d 数字： [0-9]
	 * 
	 * \D 非数字： [^0-9]
	 * 
	 * \s 空白字符： [ \t\n\x0B\f\r]
	 * 
	 * \S非空白字符： [^\s]
	 * 
	 * \w 单词字符： [a-zA-Z_0-9]
	 * 
	 * \W 非单词字符： [^\w]
	 * 
	 * \
	 * 
	 * 数量
	 * 
	 * X? X，一次或一次也没有 [0-1]
	 * 
	 * X* X，零次或多次 [0-n]
	 * 
	 * X+ X，一次或多次 [1-n]
	 * 
	 * X{n}，恰好 n 次 [n]
	 * 
	 * X{n,} X，至少 n 次 [n-]
	 * 
	 * X{n,m} X，至少 n 次，但是不超过 m 次 [n-m]
	 * 
	 * 匹配中文字符的正则表达式：[\u4e00-\u9fa5]
	 *
	 * 匹配空白行的正则表达式：\n\s*\r
	 * 
	 * 匹配首尾空白字符的正则表达式：^\s*|\s*$
	 * 
	 * 匹配Email地址的正则表达式：\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
	 * 
	 * 匹配网址URL的正则表达式：[a-zA-z]+://[^\s]*
	 * 
	 * 
	 * 匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
	 * 
	 * 匹配国内电话号码：\d{3}-\d{8}|\d{4}-\d{7} 0511-4405222 或 021-87888822
	 * 
	 * 匹配腾讯QQ号：[1-9][0-9]{4,} 腾讯QQ号从10000开始
	 * 
	 * 匹配中国邮政编码：[1-9]\d{5}(?!\d) 中国邮政编码为6位数字
	 * 
	 * 匹配身份证：\d{15}|\d{18} 中国的身份证为15位或18位
	 * 
	 * 匹配ip地址：\d+\.\d+\.\d+\.\d+ 提取ip地址时有用
	 * 
	 * 匹配特定数字：^[1-9]\d*$
	 * 
	 * 匹配正整数^-[1-9]\d*$
	 * 
	 * 匹配负整数： ^-?[1-9]\d*$
	 * 
	 * 匹配整数：^[1-9]\d*|0$
	 * 
	 * 匹配非负整数（正整数 + 0）^-[1-9]\d*|0$
	 * 
	 * 匹配非正整数（负整数 + 0）^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$
	 * 
	 * 匹配正浮点数^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$
	 * 
	 * 匹配负浮点数^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
	 * 
	 * 匹配浮点数^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$
	 * 
	 * 匹配非负浮点数（正浮点数 + 0）^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
	 * 
	 * 匹配非正浮点数（负浮点数 + 0）
	 * 
	 * 匹配特定字符串：^[A-Za-z]+$
	 * 
	 * 匹配由26个英文字母组成的字符串^[A-Z]+$
	 * 
	 * 匹配由26个英文字母的大写组成的字符串^[a-z]+$
	 * 
	 * 匹配由26个英文字母的小写组成的字符串^[A-Za-z0-9]+$
	 * 
	 * 匹配由数字和26个英文字母组成的字符串 ^\w+$
	 * 
	 */
	public static void main(String[] args) {
		// 大小写转换
		changeLowToUp();
		// ^行的开头
		p("hello sir".matches("^h.*"));
		// $行的结尾
		p("hello sir".matches(".*ir$"));
		// \b 单词边界
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		// \b 单词边界
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));

		// 符合匹配要求的
		String s = "123aa-34345bb-234cc-00";
		Pattern p = Pattern.compile("\\d{3,5}[a-z]*");
		Matcher m = p.matcher(s);

		while (m.find()) {
			System.out.println(m.group());
		}

		// 符合匹配要求的整数 从1开始
		s = "123aa-34345bb-234cc-00";
		p = Pattern.compile("(\\d{3,5})([a-z]*)");
		m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group(1));
		}
		m.reset();
		while (m.find()) {
			System.out.println(m.group(2));
		}

	}

	static void p(boolean b) {
		System.out.println(b);
	}

	static void changeLowToUp() {

		// 奇数大写 偶数小写

		String str1 = "Java JAva JAVa JAVA  I Love Android";
		Pattern p1 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		// 匹配
		Matcher m1 = p1.matcher(str1);
		int index = 1;
		StringBuffer sb = new StringBuffer();
		while (m1.find()) {
			if (index % 2 == 1) {
				m1.appendReplacement(sb, "JAVA");
			} else {
				m1.appendReplacement(sb, "java");
			}
			index++;
		}
		m1.appendTail(sb);
		System.out.println(sb);
	}
}
