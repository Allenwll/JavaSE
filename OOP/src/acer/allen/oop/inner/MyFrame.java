package acer.allen.oop.inner;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class MyFrame extends Frame {
	public MyFrame() {
		this.setTitle("对话框");
		this.setSize(500, 600);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
					System.out.println("您单击了关闭按钮");
					System.exit(0);
			}
		});
	
	}
	
}
