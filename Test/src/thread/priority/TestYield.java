package thread.priority;

/**
 * yield �ó���ǰ�ֳ���CPU��ʹ��Ȩ���������״̬����CPU����ѡ��һ���߳̽�������״̬ ������
 * 
 * �������������û���κε��̵߳ȴ�����ôֱ�ӽ�������״̬
 * 
 * @author acer
 *
 */
public class TestYield {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyThread().start();
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "------------------------" + Thread.currentThread().getName());
			Thread.yield();
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "------------------------" + getName());
			yield();
		}
	}
}
