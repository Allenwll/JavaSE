package acer.allen.oop.constructor;

public class Main {
/**
 * ʵ��������
 * �ȳ�ʼ����Ա��������ִ�й��췽���ڵĴ���
 * 
 * �����Ѿ�������� ����.class JVM��ʼ����Ӧ������ص�������
 * ͨ���������ڵ���Class���󣬰��������ڶ��ڴ���������Ӧ�Ķ��󡣶�����ֻ�����Ա�����Ŀռ�
 * ���еĸ���Ķ�����ͬһ���������ڵķ���.
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���ʵ����
		Student s = new Student();
		// ����˯������
		s.sleep();
		// ����ѧϰ����
		s.study();
		// ������ʾ����
		s.show();
		Student s1 = new Student(2016002, "Merray", 'Ů', 19, "����С��");
		// ������ʾ����
		s1.show();
		
	}

}
