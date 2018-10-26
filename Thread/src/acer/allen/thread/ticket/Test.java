package acer.allen.thread.ticket;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		Ticket ticket = new Ticket();
		Thread ticket1 = new Thread(ticket);
		ticket1.setName("1号售票员");
		ticket1.start();
		Thread ticket2 = new Thread(ticket);
		ticket2.setName("2号售票员");
		ticket2.start();
		Thread ticket3 = new Thread(ticket);
		ticket3.setName("3号售票员");
		ticket3.start();
	}

}
