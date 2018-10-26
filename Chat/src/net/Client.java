package net;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * ͼ�λ��������� �ͻ���
 * 
 * @author acer WindowListener ���ڼ�����
 * 
 *         ActionListener ��Ϊ������
 *
 */
class Client implements WindowListener, ActionListener {

	// ���
	Frame frame;

	// �Ի����ǩ ���ͱ�ǩ IP��ַ
	Label lbDialog, lbSend, lbIP;

	// ����� ����� �����
	Panel panelTop, panelMinddle, panelButtom;

	// ��ť ���� ȷ��
	Button btSend, btConfirm;

	// �ı���
	TextField tfIP, tfSend;

	// �ı���
	TextArea ta;

	// IP��ַ
	String ip;

	// �ʵ�Ա
	DatagramSocket receiveSocket, sendSocket;

	// �ʼ�
	DatagramPacket receivePacket, sendPacket;

	/**
	 * 
	 * �������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// ʵ��������
		Client client = new Client();

		// ��������
		client.creatwindow();

		// ���ÿ�ʼ����
		client.start();

		// ������Ϣ
		client.receiveMessage();
	}

	/**
	 * ��������
	 */
	void creatwindow() {

		// ʵ������� ���Դ������������
		frame = new Frame("�ͻ���");

		// ʵ���������
		panelTop = new Panel();

		tfIP = new TextField(20);

		// ʵ����IP��ǩ
		lbIP = new Label("������IP");

		// ʵ����ȷ����ť
		btConfirm = new Button("ȷ��");

		// ʵ���������
		panelMinddle = new Panel();

		// ��ǩ�Ի���
		lbDialog = new Label("�Ի���");

		// ʵ�����ı�����
		ta = new TextArea(5, 25);

		// �����ı������ܱ��޸�
		ta.setEditable(false);

		// ʵ���������
		panelButtom = new Panel();

		// ʵ�������ͱ�ǩ
		lbSend = new Label("������Ϣ");

		// ʵ���������ı���
		tfSend = new TextField(20);

		// ʵ�������Ͱ�ť
		btSend = new Button("����");

		// ��Ip��ǩ��ӽ��������
		panelTop.add(lbIP);

		// ���ı�����ӽ��������
		panelTop.add(tfIP);

		// ��ȷ����ť��ӽ��������
		panelTop.add(btConfirm);

		// ���Ի����ǩ��ӽ������
		panelMinddle.add(lbDialog);

		// ���ı�������ӽ�ȥ
		panelMinddle.add(ta);

		// �����ͱ�ǩ��ӽ������
		panelButtom.add(lbSend);

		// �������ı�����ӽ������
		panelButtom.add(tfSend);

		// �����Ͱ�ť��ӽ�ȥ
		panelButtom.add(btSend);

		// ���������뵽����� λ�� ��
		frame.add(panelTop, BorderLayout.NORTH);

		// ���������ӵ�����У�λ�� �м�
		frame.add(panelMinddle, BorderLayout.CENTER);

		// ���������ӵ�����У�λ�� ��
		frame.add(panelButtom, BorderLayout.SOUTH);

		// ���ô����С
		frame.setSize(300, 200);

		// ���ô����Ƿ�ɼ�
		frame.setVisible(true);
		
		//������󻯰�ť������
		frame.setResizable(false);
		
		// ����λ��
		frame.setLocation(100, 500);

		// ���ÿ�ܵĴ��������
		frame.addWindowListener(this);

		// ���ð�ť�Ĵ��������
		btConfirm.addActionListener(this);

		// ���ð�ť�Ĵ��������
		btSend.addActionListener(this);

	}

	/**
	 * (non-Javadoc) ����ر��¼�
	 * 
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent e) {

		// �رս��յ�socket
		receiveSocket.close();

		// �رշ��͵�socket
		sendSocket.close();

		// �����˳�
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

	// ��ʼ����
	public void start() {
		try {
			// �ͻ������Ͷ˿�
			sendSocket = new DatagramSocket(5000);
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	/**
	 * ������Ϣ
	 */
	public void receiveMessage() {
		try {
			// �ͻ������ն˿�
			receiveSocket = new DatagramSocket(3000);

			while (true) {

				// ������
				byte[] buf = new byte[200];

				// ���
				receivePacket = new DatagramPacket(buf, buf.length);

				// ����
				receiveSocket.receive(receivePacket);

				if (receivePacket.getLength() == 0) {
					ta.append("����Ϣ" + "\n");
					continue;
				}
				// �ֽ�����ת����
				ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData());

				// �ַ�������
				BufferedReader read = new BufferedReader(new InputStreamReader(bin));

				// ���ж�ȡ
				ta.append("������:" + read.readLine());

				// ����
				ta.append("\n");

				// �رն�����
				read.close();

				// �ر��ַ�������
				bin.close();
			}
		} catch (Exception e) {
			ta.append(e + "sendmessage error\n");
		}
	}

	/**
	 * ������Ϣ
	 */
	public void sendMessage() {
		try {

			// �õ��ı�
			String s = tfSend.getText();

			// ����ֵ
			tfSend.setText("");

			// ׷��
			ta.append("�ͻ���:" + s);

			ta.append("\n");

			// �ֽ����������
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			// ��ӡ��
			PrintStream pout = new PrintStream(out);

			// ��ӡ
			pout.print(s);

			// ת��Ϊ�ֽ�����
			byte[] buf = out.toByteArray();

			// װ��
			sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), 4000);

			// ����
			sendSocket.send(sendPacket);

			// �ȴ�JVM����
			buf = null;
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	/**
	 * (non-Javadoc) ��ť�¼�
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// ������Ͱ�ť
		if (e.getSource() == btSend) {

			// ������Ϣ
			sendMessage();

			// ���ȷ����ť
		} else if (e.getSource() == btConfirm) {

			// ��ֵip
			ip = tfIP.getText();

			// �����ʾ
			tfIP.setText("");
		}
	}
}
