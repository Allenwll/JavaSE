package thread.priority;

/**
 * �ػ��߳�
 * 		
 * �ڵ�ǰ�߳��е���ĳ���̵߳�setDaemon(true)����
 * 	�ڴ�������֮ǰ������start����֮��
 * 	��������ȡ����ǰ̨�߳�	
 * 		
 * 
 * @author acer
 *
 */
public class TestDaemen {
	public static void main(String[] args) {
				MyThread1 my=new MyThread1();
				my.setDaemon(true);
				my.start();
				for (int i = 0; i <10; i++) {
					System.out.println("main--------"+i);
				}
				
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		int i = 0;
		while (true)
			System.out.println(i++);
	}
}
