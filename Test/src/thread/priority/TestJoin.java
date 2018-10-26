package thread.priority;

/**
 * ����Join��
 * 
 * sleep ��ͣ  �߳�����
 *   
 *   ��һ����̬����
 *   
 *   ���߳�ִ�и÷���ʱ���̻߳�����״̬�������� �����������ߵ�ʱ�䣬��������״̬֮���ó�CPU��Դ
 *  
 * join ���
 * 
 * ��������ǰ����join����ִ�е��߳�
 * 
 * Join������̻߳�����ִ�У���������ʵ�����еĲ��
 * 
 * �²�����̣߳����������������̣߳�����ȴ��²�����߳�ִ����Ϻ󣬱��������̲߳Ż�������״̬���ȴ�CPU�ĵ���
 * 
 * yield �ó�CPU
 * 
 * @author acer
 *
 */

public class TestJoin {

	/**
	 * ��������
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// ѭ��ʮ��
		for (int i = 0; i < 10; i++) {
			//
			System.out.println("main--" + i);
			if (i == 5) {
				// ��ѭ��5�κ� ����ThreadCheng ���߳�
				ThreadCheng cheng = new ThreadCheng();// ��������״̬
				cheng.setName("��ҧ��");// �����̵߳�����
				cheng.start();// �������״̬
				/**
				 * ��� join ���߳�ִ����Ϻ�ִ��֮ǰ���߳�
				 */
				cheng.join();// ִ���������� Join ���
			}
		}

	}

}

/**
 * ������һ���߳�
 * 
 * @author acer
 *
 */
class ThreadCheng extends Thread {
	@Override
	public void run() {
		// ִ���߳�ʮ��
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + "___" + i);// ��ӡ�߳�����

		}
	}
}
