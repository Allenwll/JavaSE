package Singleton;

public class EagerSingleton {
	// ��������ģʽ
	// �������ʱ������˳�ʼ������������ؽ���������ȡ������ٶȿ�

	private static EagerSingleton instance = new EagerSingleton();// ��̬˽�г�Ա���ѳ�ʼ��

	private EagerSingleton() {
		// ˽�й��캯��
	}

	public static EagerSingleton getInstance() // ��̬������ͬ���������ʱ�ѳ�ʼ���������ж��̵߳����⣩
	{
		return instance;
	}

	

}