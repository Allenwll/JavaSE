package thread.ticket;

public class Test {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket);
		t1.setName("1号火车售票点");
		t1.start();
		Thread t2 = new Thread(ticket);
		t2.setName("2号火车售票点");
		t2.start();
		Thread t3 = new Thread(ticket);
		t3.setName("3号火车售票点");
		t3.start();
		Thread t4 = new Thread(ticket);
		t4.setName("4号火车售票点");
		t4.start();
		Thread t5 = new Thread(ticket);
		t5.setName("5号火车售票点");
		t5.start();
	}

}
