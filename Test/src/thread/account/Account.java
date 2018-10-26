package thread.account;

/**
 * �˻���
 * 
 * @author acer
 *
 */
public class Account {
	// ���
	private int balance = 1500;

	// ȡ��
	public synchronized void withdrawal(int amount) throws InterruptedException {
		if (this.balance >= amount) {
			Thread.sleep(10);
			this.balance -=amount;
			System.out.println(Thread.currentThread().getName() + "----ȡ�ֳɹ�����"+this.balance);
		} else {
			System.err.println(Thread.currentThread().getName()+"----�˻����㡣��ʣ" + this.balance);
		}
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

class AccountRunnble implements Runnable {

	Account account = new Account();

	@Override
	public void run() {
		try {
			account.withdrawal(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
