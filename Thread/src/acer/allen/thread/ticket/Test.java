package acer.allen.thread.ticket;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		Ticket ticket = new Ticket();
		Thread ticket1 = new Thread(ticket);
		ticket1.setName("1����ƱԱ");
		ticket1.start();
		Thread ticket2 = new Thread(ticket);
		ticket2.setName("2����ƱԱ");
		ticket2.start();
		Thread ticket3 = new Thread(ticket);
		ticket3.setName("3����ƱԱ");
		ticket3.start();
	}

}
