package Singleton;
	

/**
 * ���߳��µ�����ģʽ
 * @author acer
 *
 */
public class MulLazySingleton {
	// ���߳����������ʽ�ĵ���ģʽ�����ⴴ���������
	// ��Ҫʹ��synchronized�ؼ��ֺͽ�������null�ж�

	private static MulLazySingleton instance;

	private MulLazySingleton() {
	}

	public static MulLazySingleton getInstance() {
		if (instance == null) {// ����ÿ�μ�����ֻ�е�һ��û�д�������ʱ�ż���
			synchronized (MulLazySingleton.class) {// ������ֻ����һ���߳̽���
				if (instance == null) {// ֻ����һ�ζ���
					instance = new MulLazySingleton();
				}
			}
		}
		return instance;
	}

}
