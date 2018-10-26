package thread.priority;

/**
 * 守护线程
 * 		
 * 在当前线程中调用某个线程的setDaemon(true)方法
 * 	在创建对象之前，调用start方法之后
 * 	生命周期取决于前台线程	
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
