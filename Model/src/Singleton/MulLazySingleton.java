package Singleton;
	

/**
 * 多线程下的懒汉模式
 * @author acer
 *
 */
public class MulLazySingleton {
	// 多线程情况下懒汉式的单例模式，避免创建多个对象
	// 需要使用synchronized关键字和进行两次null判断

	private static MulLazySingleton instance;

	private MulLazySingleton() {
	}

	public static MulLazySingleton getInstance() {
		if (instance == null) {// 避免每次加锁，只有第一次没有创建对象时才加锁
			synchronized (MulLazySingleton.class) {// 加锁，只允许一个线程进入
				if (instance == null) {// 只创建一次对象
					instance = new MulLazySingleton();
				}
			}
		}
		return instance;
	}

}
