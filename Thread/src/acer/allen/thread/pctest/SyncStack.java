package acer.allen.thread.pctest;

/**
 * 同步栈 负责装馒头的容器 模拟栈结构 push 压栈 pop 出栈
 * 
 * @author acer
 *
 */
public class SyncStack {
	// 负责容纳馒头的容器
	private SteamBread[] breads = new SteamBread[6];
	// 模拟栈顶的索引
	private int index;

	public SteamBread[] getBread() {
		return breads;
	}

	public void setBread(SteamBread[] breads) {
		this.breads = breads;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 压栈 生产者线程调用push方法 如果 在push中调用了 wait方法 那么生产者线程线程会对当前对象this解锁 释放监视权 当其他线程
	 * 消费者线程 这个线程拥有当前对象的监视权 调用了notify方法 会唤醒在当前对象上等待的线程
	 * 
	 * @param bread
	 *            馒头
	 * @throws InterruptedException
	 */
	public synchronized void push(SteamBread bread) throws InterruptedException {
		// 是否满了
		if (index == breads.length) {
			// System.out.println("满了");
			wait();
		}
		breads[index] = bread;
		index++;
		// 通知消费者去消费
		System.out.println("生产者生产了" + bread);
		Thread.sleep(1000);
		notify();
	}

	/**
	 * 出栈
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized void pop() throws InterruptedException {
		if (index == 0) {
			// System.out.println("容器空了");
			wait();
		}
		index--;
		// 通知生产者去生产
		notify();
		System.out.println("消费者消费了" + breads[index]);
		Thread.sleep(1000);
	}
}
