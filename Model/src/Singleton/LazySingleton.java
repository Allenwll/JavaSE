package Singleton;

public class LazySingleton {
	// ����ʽ����ģʽ
	// �Ƚ������������ʱ��������ʵ�������������ٶȿ죬������ʱ��ȡ������ٶ���

	private static LazySingleton intance = null;// ��̬˽�ó�Ա��û�г�ʼ��

	private LazySingleton() {
		// ˽�й��캯��
	}

	public static synchronized LazySingleton getInstance() // ��̬��ͬ�����������ʵ�
	{
		if (intance == null) {
			intance = new LazySingleton();
		}
		return intance;
	}
}
