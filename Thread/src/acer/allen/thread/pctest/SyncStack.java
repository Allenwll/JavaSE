package acer.allen.thread.pctest;

/**
 * ͬ��ջ ����װ��ͷ������ ģ��ջ�ṹ push ѹջ pop ��ջ
 * 
 * @author acer
 *
 */
public class SyncStack {
	// ����������ͷ������
	private SteamBread[] breads = new SteamBread[6];
	// ģ��ջ��������
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
	 * ѹջ �������̵߳���push���� ��� ��push�е����� wait���� ��ô�������߳��̻߳�Ե�ǰ����this���� �ͷż���Ȩ �������߳�
	 * �������߳� ����߳�ӵ�е�ǰ����ļ���Ȩ ������notify���� �ỽ���ڵ�ǰ�����ϵȴ����߳�
	 * 
	 * @param bread
	 *            ��ͷ
	 * @throws InterruptedException
	 */
	public synchronized void push(SteamBread bread) throws InterruptedException {
		// �Ƿ�����
		if (index == breads.length) {
			// System.out.println("����");
			wait();
		}
		breads[index] = bread;
		index++;
		// ֪ͨ������ȥ����
		System.out.println("������������" + bread);
		Thread.sleep(1000);
		notify();
	}

	/**
	 * ��ջ
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized void pop() throws InterruptedException {
		if (index == 0) {
			// System.out.println("��������");
			wait();
		}
		index--;
		// ֪ͨ������ȥ����
		notify();
		System.out.println("������������" + breads[index]);
		Thread.sleep(1000);
	}
}
