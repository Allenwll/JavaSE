
package acer.allen.system;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		/*
		 * System.out.println("当前时间：" + time); long sum = 0; for (long i = 0; i
		 * < 1000000; i++) { sum += i; } System.out.println("差值：" +
		 * (System.currentTimeMillis() - time)); try { Thread.sleep(5000); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("睡眠了5秒之后：" +
		 * System.currentTimeMillis()); System.exit(0);
		 */
		boolean flag=true;
		int count=0;
		while(flag){
			if((System.currentTimeMillis()-time)>1000){
				flag=false;
			}
			count++;
		}
	}
}
