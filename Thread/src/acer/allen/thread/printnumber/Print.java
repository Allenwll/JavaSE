package acer.allen.thread.printnumber;

public class Print {

	private int i = 1;
	private char j = 'A';

	public Print() {
	}

	public synchronized void printNumber() {// ͬ������
		System.out.print(String.valueOf(i) + String.valueOf(i + 1));
		i += 2;
		notifyAll(); // �Ȼ����������̣������������̣����˳��ߵ��ˣ��������������ٻ�����������
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void printWord() {
		System.out.print(j);
		j++;
		notifyAll();
		try {
			if (j <= 'Z')// ���Z֮��Ͳ����ٵȴ��ˡ�
			{

				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}