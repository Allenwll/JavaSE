package thread.account;

public class Test {

	public static void main(String[] args) {
		AccountRunnble ar = new AccountRunnble();
		Thread t = new Thread(ar);
		t.setName("�ɷ�");
		t.start();
		Thread t1 = new Thread(ar);
		t1.setName("����");
		t1.start();
	}

}
