package acer.allen.oop.test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �������ʵ����
		Student[] s = new Student[10];
		// �������ͱ���
		int sum = 0;
		// ѭ����ֵ
		for (int i = 0; i < s.length; i++) {
			s[i] = new Student();
			sum += s[i].score;
		}
		// ѭ����ӡ����Ԫ��
		for (int i = 0; i < s.length; i++) {
			System.out.println("������Ԫ��Ϊ��" + s[i].score);
		}
		// ��ӡ�ܺͺ�ƽ��ֵ
		System.out.println("�ܺ�Ϊ:" + sum + "\n ƽ��ֵΪ:" + (sum / s.length));
	}

}
