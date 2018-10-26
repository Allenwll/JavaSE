package net;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * 可视化服务器端
 * 
 * @author acer WindowListener 窗口监听器
 * 
 *         ActionListener 行为监听器
 *
 */
class Server implements WindowListener, ActionListener {

	// 框架
	Frame frame;

	// 面板 上 下
	Panel panelTop, panelButtom;

	// 标签 对话框 发送消息
	Label lbDialog, lbSend;

	// 文本区域
	TextArea ta;

	// 文本框
	TextField tfContent;

	// 确定按钮
	Button btConfirm;

	// 接收对象 发送对象
	DatagramSocket receiveSocket, sendSocket;

	// 封包 拆包
	DatagramPacket receivePacket, sendPacket;

	// IP地址
	InetAddress ip;

	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		server.creatwindow();
		server.start();
		server.receiveMessage();
	}

	void creatwindow() {
		frame = new Frame("服务器端");
		panelTop = new Panel();
		panelButtom = new Panel();
		lbDialog = new Label("对话框");
		lbSend = new Label("发送消息");
		ta = new TextArea(7, 20);
		tfContent = new TextField(15);
		btConfirm = new Button("发送");
		ta.setEditable(false);
		panelTop.add(lbDialog);
		panelTop.add(ta);
		panelButtom.add(lbSend);
		panelButtom.add(tfContent);
		panelButtom.add(btConfirm);
		frame.addWindowListener(this);
		btConfirm.addActionListener(this);
		frame.add(panelTop, BorderLayout.NORTH);
		// f.add(panelButtom,BorderLayout.CENTER);
		frame.add(panelButtom, BorderLayout.SOUTH);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setLocation(100, 500);
	}

	public void windowClosing(WindowEvent e) {
		receiveSocket.close();
		sendSocket.close();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void start() {
		try {
			sendSocket = new DatagramSocket(6000);// 服务器发送端口
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	public void receiveMessage()// 服务器发送消息
	{
		try {
			receiveSocket = new DatagramSocket(4000);// 服务器接收端口
			while (true) {
				byte[] buf = new byte[200];
				receivePacket = new DatagramPacket(buf, buf.length);
				receiveSocket.receive(receivePacket);
				ip = receivePacket.getAddress();
				if (receivePacket.getLength() == 0) {
					ta.append("空消息\n");
					continue;
				}
				ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData());
				BufferedReader read = new BufferedReader(new InputStreamReader(bin));
				ta.append("客户端:" + read.readLine());
				ta.append("\n");
				read.close();
				bin.close();
			}
		} catch (Exception e) {
			ta.append(e + "sendmessage error\n");
		}
	}

	public void sendMessage() {
		try {
			String s = tfContent.getText();
			tfContent.setText("");
			ta.append("服务器:" + s);
			ta.append("\n");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			PrintStream pout = new PrintStream(out);
			pout.print(s);
			byte[] buf = out.toByteArray();
			sendPacket = new DatagramPacket(buf, buf.length, ip, 3000);
			sendSocket.send(sendPacket);
			buf = null;
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btConfirm) {
			sendMessage();
		}
	}
}
