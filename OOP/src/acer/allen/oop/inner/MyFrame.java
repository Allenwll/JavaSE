package acer.allen.oop.inner;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MyFrame extends Frame {
	public MyFrame() {
		this.setTitle("�Ի���");
		this.setSize(500, 600);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					System.out.println("�������˹رհ�ť");
					System.exit(0);
			}
		});
	
	}
	
}
