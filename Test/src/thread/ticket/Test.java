package thread.ticket;

public class Test {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket);
		t1.setName("1�Ż���Ʊ��");
		t1.start();
		Thread t2 = new Thread(ticket);
		t2.setName("2�Ż���Ʊ��");
		t2.start();
		Thread t3 = new Thread(ticket);
		t3.setName("3�Ż���Ʊ��");
		t3.start();
		Thread t4 = new Thread(ticket);
		t4.setName("4�Ż���Ʊ��");
		t4.start();
		Thread t5 = new Thread(ticket);
		t5.setName("5�Ż���Ʊ��");
		t5.start();
	}

}
