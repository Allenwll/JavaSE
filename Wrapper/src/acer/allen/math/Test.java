package acer.allen.math;

public class Test {

	public static void main(String[] args) {
		// �õ�0-100�������
		double d = (Math.random() * 100);
		System.out.println("�õ��������Ϊ:" + d);
		System.out.println("-------------------------");
		System.out.println("���������Ϊ��" + Math.round(d));
		System.out.println("-------------------------");
		System.out.println("��ƽ����Ϊ��" + Math.sqrt(d));
		System.out.println("-------------------------");
		System.out.println("��������Ϊ��" + Math.cbrt(d));
		System.out.println("-------------------------");
		System.out.println("����ȡ��Ϊ��" + Math.floor(d));
		System.out.println("-------------------------");
		System.out.println("����ȡ��Ϊ��" + Math.ceil(d));

	}

}
