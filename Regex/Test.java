package acer.allen.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试类
 * 
 * @author acer
 *
 */
public class Test {
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
	 * 数量
	 * 
	 * X? X，一次或一次也没有 [0-1]
	 * 
	 *X* X，零次或多次 [0-n]
	 * 
	 *X+ X，一次或多次 [1-n]
	 * 
	 *X{n}，恰好 n 次 [n]
	 * 
	 *X{n,} X，至少 n 次 [n-]
	 * 
	 *X{n,m} X，至少 n 次，但是不超过 m 次 [n-m]
	 * 
	 *匹配中文字符的正则表达式：[\u4e00-\u9fa5]
	 *
	 *匹配空白行的正则表达式：\n\s*\r
	 * 
	 *匹配首尾空白字符的正则表达式：^\s*|\s*$
	 * 
	 *匹配Email地址的正则表达式：\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
	 * 
	 *匹配网址URL的正则表达式：[a-zA-z]+://[^\s]*
	 * 
	 * 
	 *匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
	 * 
	 *匹配国内电话号码：\d{3}-\d{8}|\d{4}-\d{7} 0511-4405222 或 021-87888822
	 * 
	 *匹配腾讯QQ号：[1-9][0-9]{4,} 腾讯QQ号从10000开始
	 * 
	 *匹配中国邮政编码：[1-9]\d{5}(?!\d) 中国邮政编码为6位数字
	 *  
	 *匹配身份证：\d{15}|\d{18} 中国的身份证为15位或18位
	 * 
	 *匹配ip地址：\d+\.\d+\.\d+\.\d+ 提取ip地址时有用
	 * 
	 *匹配特定数字：^[1-9]\d*$
	 * 
	 *匹配正整数^-[1-9]\d*$
	 * 
	 *匹配负整数： ^-?[1-9]\d*$
	 * 
	 *匹配整数：^[1-9]\d*|0$
	 * 
	 *匹配非负整数（正整数 + 0）^-[1-9]\d*|0$
	 * 
	 *匹配非正整数（负整数 + 0）^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$
	 * 
	 *匹配正浮点数^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$
	 * 
	 *匹配负浮点数^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
	 * 
	 *匹配浮点数^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$
	 * 
	 *匹配非负浮点数（正浮点数 + 0）^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
	 * 
	 *匹配非正浮点数（负浮点数 + 0）
	 * 
	 *匹配特定字符串：^[A-Za-z]+$
	 * 
	 *匹配由26个英文字母组成的字符串^[A-Z]+$
	 * 
	 *匹配由26个英文字母的大写组成的字符串^[a-z]+$
	 * 
	 *匹配由26个英文字母的小写组成的字符串^[A-Za-z0-9]+$
	 * 
	 *匹配由数字和26个英文字母组成的字符串 ^\w+$
	 * 
	 */
	public static void main(String[] args) {

		test("V".matches("[a-z[A-Z]]"));

		// 控制台输入
		/*
		 * Scanner s = new Scanner(System.in); // 接收
		 * System.out.println("请输入字符串:"); String str = s.nextLine(); // 模式
		 * Pattern p = Pattern.compile("[A-Z[a-z]][A-Z[a-z]0-9]{5}");
		 * 
		 * // 匹配结果 Matcher m = p.matcher(str);
		 * 
		 * System.out.println("是否符合要求:" + m.matches());
		 * 
		 * p = Pattern.compile("[1-9][0-9]{4,14}"); System.out.println("是否符合要求:"
		 * + testQQ(str));
		 */

		test("a".matches("."));// true

		// X* X，零次或多次 [0-n]
		test("aaaaaa".matches("a*"));// true
		// X?X，一次或一次也没有 [0-1]
		test("aa".matches("a?"));// false
		// X+ X，一次或多次[1-n]
		test("a".matches("a+"));// true // X{n}，恰好 n 次 [n]
		test("aaaa".matches("a{3}"));// false
		// X{n,} X，至少 n 次 [n-]
		test("aaaa".matches("a{3,}"));// true
		// X{n,m} X，至少 n 次，但是不超过 m 次[n-m]
		test("aaaa".matches("a{3,7}"));// true
		// 3-100个字符
		test("1232154654".matches("\\d{3,100}"));
		// IP地址
		test("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		// 范围匹配 []是一个范围 [代表了一个字符]
		test("a".matches("[abc]"));// true
		test("a".matches("[^abc]"));// false
		test("a".matches("[a-zA-Z]"));// true
		test("a".matches("[a-z]|[A-Z]"));// true
		test("a".matches("[a-z[A-Z]]"));// true
		test("a".matches("[a-z&&[abc]]"));// true

		test("abc888%&*".matches("[a-c]{1,3}\\d{1,3}[&*%]+"));

		// 匹配特殊字符
		test("\\".matches("\\\\"));

		test("abc2".matches("\\w{3,}"));

		test("\t\n\t".matches("\\s{3}"));
		/// s 代表空白字符 制表符 回车 换行 推格
		test("  \t\n\t".matches("\\s+"));

		test("abc888%&*".matches("\\w{6}[&*%]+"));

		// 验证汉字

		test("好".matches("[\u4e00-\u9fa5]"));

		// find 查找子串
		Pattern pattern = Pattern.compile("\\d{3,5}");
		String str = "342-54815-156-25";
		Matcher matcher = pattern.matcher(str);

		// 整体匹配 游标到 342-
		System.out.println(matcher.matches());

		// 重置游标
		matcher.reset();

		int start = 0;
		int end = 0;
		test(matcher.find());
		start = matcher.start();
		end = matcher.end();
		System.err.println("start:" + start + "------------end:" + end);
		test(matcher.find());
		start = matcher.start();
		end = matcher.end();
		System.err.println("start:" + start + "------------end:" + end);
		test(matcher.find());
		start = matcher.start();
		end = matcher.end();
		System.err.println("start:" + start + "------------end:" + end);
		test(matcher.find());

		// 替换成小写

		System.out.println("java Java JAva JAVA".replaceAll("[Jj][Aa][Vv][Aa]", "JAVA"));

		// Pattern.CASE_INSENSITIVE 不区分大小写
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		// 匹配
		Matcher m = p.matcher("java Java JAva JAVA");
		// 全部替换
		System.out.println(m.replaceAll("java"));

		//
		// test("a".matches("\\p{Lower}"));

		// 汉字开始
		System.out.println("\u4e00");
		// 汉字结束
		System.out.println("\u9fa5");

	}

	static boolean testQQ(String qq) {
		boolean result = true;

		if (qq != null) {
			int len = qq.length();
			if (len >= 5) {
				if (len > 15) {
					System.out.println("长度过长！");
					return false;
				}
				if (qq.startsWith("0")) {
					result = false;
					System.out.println("第一个字符不能为0");
				} else {
					for (int i = 0; i < len; i++) {
						char c = qq.charAt(i);
						if (c < '0' || c > '9') {
							System.out.println("字符串不合法!");
							return false;
						}
					}
				}
			} else {
				System.out.println("长度不能小于5！");
				return false;
			}
		} else {
			System.out.println("QQ不能为空！");
			return false;
		}

		return result;
	}

	static void test(boolean b) {
		System.out.println(b);
	}
}
