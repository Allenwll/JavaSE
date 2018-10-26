package net;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * ���ӻ���������
 * 
 * @author acer WindowListener ���ڼ�����
 * 
 *         ActionListener ��Ϊ������
 *
 */
class Server implements WindowListener, ActionListener {

	// ���
	Frame frame;

	// ��� �� ��
	Panel panelTop, panelButtom;

	// ��ǩ �Ի��� ������Ϣ
	Label lbDialog, lbSend;

	// �ı�����
	TextArea ta;

	// �ı���
	TextField tfContent;

	// ȷ����ť
	Button btConfirm;

	// ���ն��� ���Ͷ���
	DatagramSocket receiveSocket, sendSocket;

	// ��� ���
	DatagramPacket receivePacket, sendPacket;

	// IP��ַ
	InetAddress ip;

	/**
	 * ��������
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server();
		server.creatwindow();
		server.start();
		server.receiveMessage();
	}

	void creatwindow() {
		frame = new Frame("��������");
		panelTop = new Panel();
		panelButtom = new Panel();
		lbDialog = new Label("�Ի���");
		lbSend = new Label("������Ϣ");
		ta = new TextArea(7, 20);
		tfContent = new TextField(15);
		btConfirm = new Button("����");
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
			sendSocket = new DatagramSocket(6000);// ���������Ͷ˿�
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	public void receiveMessage()// ������������Ϣ
	{
		try {
			receiveSocket = new DatagramSocket(4000);// ���������ն˿�
			while (true) {
				byte[] buf = new byte[200];
				receivePacket = new DatagramPacket(buf, buf.length);
				receiveSocket.receive(receivePacket);
				ip = receivePacket.getAddress();
				if (receivePacket.getLength() == 0) {
					ta.append("����Ϣ\n");
					continue;
				}
				ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData());
				BufferedReader read = new BufferedReader(new InputStreamReader(bin));
				ta.append("�ͻ���:" + read.readLine());
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
			ta.append("������:" + s);
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
