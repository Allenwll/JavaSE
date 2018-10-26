package acer.allen.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
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
	 * \
	 * 
	 * ����
	 * 
	 * X? X��һ�λ�һ��Ҳû�� [0-1]
	 * 
	 * X* X����λ��� [0-n]
	 * 
	 * X+ X��һ�λ��� [1-n]
	 * 
	 * X{n}��ǡ�� n �� [n]
	 * 
	 * X{n,} X������ n �� [n-]
	 * 
	 * X{n,m} X������ n �Σ����ǲ����� m �� [n-m]
	 * 
	 * ƥ�������ַ���������ʽ��[\u4e00-\u9fa5]
	 *
	 * ƥ��հ��е�������ʽ��\n\s*\r
	 * 
	 * ƥ����β�հ��ַ���������ʽ��^\s*|\s*$
	 * 
	 * ƥ��Email��ַ��������ʽ��\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
	 * 
	 * ƥ����ַURL��������ʽ��[a-zA-z]+://[^\s]*
	 * 
	 * 
	 * ƥ���ʺ��Ƿ�Ϸ�(��ĸ��ͷ������5-16�ֽڣ�������ĸ�����»���)��^[a-zA-Z][a-zA-Z0-9_]{4,15}$
	 * 
	 * ƥ����ڵ绰���룺\d{3}-\d{8}|\d{4}-\d{7} 0511-4405222 �� 021-87888822
	 * 
	 * ƥ����ѶQQ�ţ�[1-9][0-9]{4,} ��ѶQQ�Ŵ�10000��ʼ
	 * 
	 * ƥ���й��������룺[1-9]\d{5}(?!\d) �й���������Ϊ6λ����
	 * 
	 * ƥ�����֤��\d{15}|\d{18} �й������֤Ϊ15λ��18λ
	 * 
	 * ƥ��ip��ַ��\d+\.\d+\.\d+\.\d+ ��ȡip��ַʱ����
	 * 
	 * ƥ���ض����֣�^[1-9]\d*$
	 * 
	 * ƥ��������^-[1-9]\d*$
	 * 
	 * ƥ�为������ ^-?[1-9]\d*$
	 * 
	 * ƥ��������^[1-9]\d*|0$
	 * 
	 * ƥ��Ǹ������������� + 0��^-[1-9]\d*|0$
	 * 
	 * ƥ����������������� + 0��^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$
	 * 
	 * ƥ����������^-([1-9]\d*\.\d*|0\.\d*[1-9]\d*)$
	 * 
	 * ƥ�为������^-?([1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0)$
	 * 
	 * ƥ�両����^[1-9]\d*\.\d*|0\.\d*[1-9]\d*|0?\.0+|0$
	 * 
	 * ƥ��Ǹ����������������� + 0��^(-([1-9]\d*\.\d*|0\.\d*[1-9]\d*))|0?\.0+|0$
	 * 
	 * ƥ��������������������� + 0��
	 * 
	 * ƥ���ض��ַ�����^[A-Za-z]+$
	 * 
	 * ƥ����26��Ӣ����ĸ��ɵ��ַ���^[A-Z]+$
	 * 
	 * ƥ����26��Ӣ����ĸ�Ĵ�д��ɵ��ַ���^[a-z]+$
	 * 
	 * ƥ����26��Ӣ����ĸ��Сд��ɵ��ַ���^[A-Za-z0-9]+$
	 * 
	 * ƥ�������ֺ�26��Ӣ����ĸ��ɵ��ַ��� ^\w+$
	 * 
	 */
	public static void main(String[] args) {
		// ��Сдת��
		changeLowToUp();
		// ^�еĿ�ͷ
		p("hello sir".matches("^h.*"));
		// $�еĽ�β
		p("hello sir".matches(".*ir$"));
		// \b ���ʱ߽�
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		// \b ���ʱ߽�
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));

		// ����ƥ��Ҫ���
		String s = "123aa-34345bb-234cc-00";
		Pattern p = Pattern.compile("\\d{3,5}[a-z]*");
		Matcher m = p.matcher(s);

		while (m.find()) {
			System.out.println(m.group());
		}

		// ����ƥ��Ҫ������� ��1��ʼ
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

		// ������д ż��Сд

		String str1 = "Java JAva JAVa JAVA  I Love Android";
		Pattern p1 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		// ƥ��
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
