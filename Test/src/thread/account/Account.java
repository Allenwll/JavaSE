package thread.account;

/**
 * 账户类
 * 
 * @author acer
 *
 */
public class Account {
	// 余额
	private int balance = 1500;

	// 取现
	public synchronized void withdrawal(int amount) throws InterruptedException {
		if (this.balance >= amount) {
			Thread.sleep(10);
			this.balance -=amount;
			System.out.println(Thread.currentThread().getName() + "----取现成功！余额："+this.balance);
		} else {
			System.err.println(Thread.currentThread().getName()+"----账户余额不足。还剩" + this.balance);
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
