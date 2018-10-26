package acer.allen.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������
 * 
 * @author acer
 *
 */
public class Test {
	/**
	 * .���������ַ� split�в���ʹ�� \d ���֣� [0-9]
	 * 
	 * \D �����֣� [^0-9]
	 * 
	 * \s �հ��ַ��� [ \t\n\x0B\f\r]
	 * 
	 * \S�ǿհ��ַ��� [^\s]
	 * 
	 * \w �����ַ��� [a-zA-Z_0-9]
	 * 
	 * \W �ǵ����ַ��� [^\w]
	 * 
	 * ����
	 * 
	 * X? X��һ�λ�һ��Ҳû�� [0-1]
	 * 
	 *X* X����λ��� [0-n]
	 * 
	 *X+ X��һ�λ��� [1-n]
	 * 
	 *X{n}��ǡ�� n �� [n]
	 * 
	 *X{n,} X������ n �� [n-]
	 * 
	 *X{n,m} X������ n �Σ����ǲ����� m �� [n-m]
	 * 
	 *ƥ�������ַ���������ʽ��[\u4e00-\u9fa5]
	 *
	 *ƥ��հ��е�������ʽ��\n\s*\r
	 * 
	 *ƥ����β�հ��ַ���������ʽ��^\s*|\s*$
	 * 
	 *ƥ��Email��ַ��������ʽ��\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
	 * 
	 *ƥ����ַURL��������ʽ��[a-zA-z]+://[^\s]*
	 * 
	 * 
	 *ƥ���ʺ��Ƿ�Ϸ�(��ĸ��ͷ������5-16�ֽڣ�������ĸ�����»���)��^[a-zA-Z][a-zA-Z0-9_]{4,15}$
	 * 
	 *ƥ����ڵ绰���룺\d{3}-\d{8}|\d{4}-\d{7} 0511-4405222 �� 021-87888822
	 * 
	 *ƥ����ѶQQ�ţ�[1-9][0-9]{4,} ��ѶQQ�Ŵ�10000��ʼ
	 * 
	 *ƥ���й��������룺[1-9]\d{5}(?!\d) �й���������Ϊ6λ����
	 *  
	 *ƥ�����֤��\d{15}|\d{18} �й������֤Ϊ15λ��18λ
	 * 
	 *ƥ��ip��ַ��\d+\.\d+\.\d+\.\d+ ��ȡip��ַʱ����
	 * 
	 *ƥ���ض����֣�^[1-9]\d*$
	 * 
	 *ƥ��������^-[1-9]\d*$
	 * 
	 *ƥ�为������ ^-?[1-9]\d*$
	 * 
	 *ƥ��������^[1-9]\d*|0$
	 * 
	 *ƥ��Ǹ������������� + 0��^-[1-9]\d*|0$
	 * 
	 *ƥ����������������� + 0��^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$
	 * 
	 *ƥ����������^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$
	 * 
	 *ƥ�为������^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
	 * 
	 *ƥ�両����^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$
	 * 
	 *ƥ��Ǹ����������������� + 0��^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
	 * 
	 *ƥ��������������������� + 0��
	 * 
	 *ƥ���ض��ַ�����^[A-Za-z]+$
	 * 
	 *ƥ����26��Ӣ����ĸ��ɵ��ַ���^[A-Z]+$
	 * 
	 *ƥ����26��Ӣ����ĸ�Ĵ�д��ɵ��ַ���^[a-z]+$
	 * 
	 *ƥ����26��Ӣ����ĸ��Сд��ɵ��ַ���^[A-Za-z0-9]+$
	 * 
	 *ƥ�������ֺ�26��Ӣ����ĸ��ɵ��ַ��� ^\w+$
	 * 
	 */
	public static void main(String[] args) {

		test("V".matches("[a-z[A-Z]]"));

		// ����̨����
		/*
		 * Scanner s = new Scanner(System.in); // ����
		 * System.out.println("�������ַ���:"); String str = s.nextLine(); // ģʽ
		 * Pattern p = Pattern.compile("[A-Z[a-z]][A-Z[a-z]0-9]{5}");
		 * 
		 * // ƥ���� Matcher m = p.matcher(str);
		 * 
		 * System.out.println("�Ƿ����Ҫ��:" + m.matches());
		 * 
		 * p = Pattern.compile("[1-9][0-9]{4,14}"); System.out.println("�Ƿ����Ҫ��:"
		 * + testQQ(str));
		 */

		test("a".matches("."));// true

		// X* X����λ��� [0-n]
		test("aaaaaa".matches("a*"));// true
		// X?X��һ�λ�һ��Ҳû�� [0-1]
		test("aa".matches("a?"));// false
		// X+ X��һ�λ���[1-n]
		test("a".matches("a+"));// true // X{n}��ǡ�� n �� [n]
		test("aaaa".matches("a{3}"));// false
		// X{n,} X������ n �� [n-]
		test("aaaa".matches("a{3,}"));// true
		// X{n,m} X������ n �Σ����ǲ����� m ��[n-m]
		test("aaaa".matches("a{3,7}"));// true
		// 3-100���ַ�
		test("1232154654".matches("\\d{3,100}"));
		// IP��ַ
		test("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		// ��Χƥ�� []��һ����Χ [������һ���ַ�]
		test("a".matches("[abc]"));// true
		test("a".matches("[^abc]"));// false
		test("a".matches("[a-zA-Z]"));// true
		test("a".matches("[a-z]|[A-Z]"));// true
		test("a".matches("[a-z[A-Z]]"));// true
		test("a".matches("[a-z&&[abc]]"));// true

		test("abc888%&*".matches("[a-c]{1,3}\\d{1,3}[&*%]+"));

		// ƥ�������ַ�
		test("\\".matches("\\\\"));

		test("abc2".matches("\\w{3,}"));

		test("\t\n\t".matches("\\s{3}"));
		/// s ����հ��ַ� �Ʊ�� �س� ���� �Ƹ�
		test("  \t\n\t".matches("\\s+"));

		test("abc888%&*".matches("\\w{6}[&*%]+"));

		// ��֤����

		test("��".matches("[\u4e00-\u9fa5]"));

		// find �����Ӵ�
		Pattern pattern = Pattern.compile("\\d{3,5}");
		String str = "342-54815-156-25";
		Matcher matcher = pattern.matcher(str);

		// ����ƥ�� �α굽 342-
		System.out.println(matcher.matches());

		// �����α�
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

		// �滻��Сд

		System.out.println("java Java JAva JAVA".replaceAll("[Jj][Aa][Vv][Aa]", "JAVA"));

		// Pattern.CASE_INSENSITIVE �����ִ�Сд
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		// ƥ��
		Matcher m = p.matcher("java Java JAva JAVA");
		// ȫ���滻
		System.out.println(m.replaceAll("java"));

		//
		// test("a".matches("\\p{Lower}"));

		// ���ֿ�ʼ
		System.out.println("\u4e00");
		// ���ֽ���
		System.out.println("\u9fa5");

	}

	static boolean testQQ(String qq) {
		boolean result = true;

		if (qq != null) {
			int len = qq.length();
			if (len >= 5) {
				if (len > 15) {
					System.out.println("���ȹ�����");
					return false;
				}
				if (qq.startsWith("0")) {
					result = false;
					System.out.println("��һ���ַ�����Ϊ0");
				} else {
					for (int i = 0; i < len; i++) {
						char c = qq.charAt(i);
						if (c < '0' || c > '9') {
							System.out.println("�ַ������Ϸ�!");
							return false;
						}
					}
				}
			} else {
				System.out.println("���Ȳ���С��5��");
				return false;
			}
		} else {
			System.out.println("QQ����Ϊ�գ�");
			return false;
		}

		return result;
	}

	static void test(boolean b) {
		System.out.println(b);
	}
}
