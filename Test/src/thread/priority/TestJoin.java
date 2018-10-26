package thread.priority;

/**
 * 测试Join类
 * 
 * sleep 暂停  线程休眠
 *   
 *   是一个静态方法
 *   
 *   当线程执行该方法时，线程会休眠状态（阻塞） 可以设置休眠的时间，进入阻塞状态之后，让出CPU资源
 *  
 * join 插队
 * 
 * 会阻塞当前调用join方法执行的线程
 * 
 * Join进入的线程会优先执行，类似于现实生活中的插队
 * 
 * 新插入的线程，会阻塞调用它的线程，必须等待新插入的线程执行完毕后，被阻塞的线程才会进入就绪状态。等待CPU的调度
 * 
 * yield 让出CPU
 * 
 * @author acer
 *
 */

public class TestJoin {

	/**
	 * 程序的入口
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// 循环十次
		for (int i = 0; i < 10; i++) {
			//
			System.out.println("main--" + i);
			if (i == 5) {
				// 当循环5次后 开启ThreadCheng 的线程
				ThreadCheng cheng = new ThreadCheng();// 进入新生状态
				cheng.setName("程咬金");// 设置线程的名字
				cheng.start();// 进入就绪状态
				/**
				 * 插队 join 等线程执行完毕后，执行之前的线程
				 */
				cheng.join();// 执行阻塞方法 Join 插队
			}
		}

	}

}

/**
 * 开启另一个线程
 * 
 * @author acer
 *
 */
class ThreadCheng extends Thread {
	@Override
	public void run() {
		// 执行线程十次
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + "___" + i);// 打印线程名字

		}
	}
}
