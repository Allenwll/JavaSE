package acer.allen.integer;

public class Test {

	public static void main(String[] args) {

		// 基本数据类型-->封装类
		int i = 5;
		Integer integer = new Integer(i);
		// 封装类-->基本数据类型
		i = integer.intValue();
		// String-->封装类
		integer = new Integer("150");
		// 封装类-->String
		String str = integer.toString();
		// int a=String.valueOf(b);
		// String-->基本数据类型
		int num = Integer.parseInt(str);
		// 基本数据类型-->String
		str = Integer.toString(num);

		// JDK1.5之后提供了 自动装箱
		integer = 3;
		// 自动拆箱
		num = integer;
	}

}
