package thread.account;

public class Test {

	public static void main(String[] args) {
		AccountRunnble ar = new AccountRunnble();
		Thread t = new Thread(ar);
		t.setName("ÕÉ·ò");
		t.start();
		Thread t1 = new Thread(ar);
		t1.setName("ÆŞ×Ó");
		t1.start();
	}

}
