package acer.allen.integer;

public class Test {

	public static void main(String[] args) {

		// ������������-->��װ��
		int i = 5;
		Integer integer = new Integer(i);
		// ��װ��-->������������
		i = integer.intValue();
		// String-->��װ��
		integer = new Integer("150");
		// ��װ��-->String
		String str = integer.toString();
		// int a=String.valueOf(b);
		// String-->������������
		int num = Integer.parseInt(str);
		// ������������-->String
		str = Integer.toString(num);

		// JDK1.5֮���ṩ�� �Զ�װ��
		integer = 3;
		// �Զ�����
		num = integer;
	}

}
