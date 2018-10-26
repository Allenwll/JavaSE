package net;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * 图形化界面聊天 客户端
 * 
 * @author acer WindowListener 窗口监听器
 * 
 *         ActionListener 行为监听器
 *
 */
class Client implements WindowListener, ActionListener {

	// 框架
	Frame frame;

	// 对话框标签 发送标签 IP地址
	Label lbDialog, lbSend, lbIP;

	// 上面板 中面板 下面板
	Panel panelTop, panelMinddle, panelButtom;

	// 按钮 发送 确定
	Button btSend, btConfirm;

	// 文本框
	TextField tfIP, tfSend;

	// 文本区
	TextArea ta;

	// IP地址
	String ip;

	// 邮递员
	DatagramSocket receiveSocket, sendSocket;

	// 邮件
	DatagramPacket receivePacket, sendPacket;

	/**
	 * 
	 * 程序入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 实例化本类
		Client client = new Client();

		// 创建窗口
		client.creatwindow();

		// 调用开始方法
		client.start();

		// 接收信息
		client.receiveMessage();
	}

	/**
	 * 创建窗口
	 */
	void creatwindow() {

		// 实例化框架 并对窗体标题栏命名
		frame = new Frame("客户端");

		// 实例化上面板
		panelTop = new Panel();

		tfIP = new TextField(20);

		// 实例化IP标签
		lbIP = new Label("服务器IP");

		// 实例化确定按钮
		btConfirm = new Button("确定");

		// 实例化中面板
		panelMinddle = new Panel();

		// 标签对话框
		lbDialog = new Label("对话框");

		// 实例化文本区域
		ta = new TextArea(5, 25);

		// 设置文本区域不能被修改
		ta.setEditable(false);

		// 实例化下面板
		panelButtom = new Panel();

		// 实例化发送标签
		lbSend = new Label("发送消息");

		// 实例化发送文本框
		tfSend = new TextField(20);

		// 实例化发送按钮
		btSend = new Button("发送");

		// 将Ip标签添加进上面板中
		panelTop.add(lbIP);

		// 将文本框添加进上面板中
		panelTop.add(tfIP);

		// 将确定按钮添加进上面板中
		panelTop.add(btConfirm);

		// 将对话框标签添加进中面板
		panelMinddle.add(lbDialog);

		// 将文本区域添加进去
		panelMinddle.add(ta);

		// 将发送标签添加进下面板
		panelButtom.add(lbSend);

		// 将发送文本框添加进下面板
		panelButtom.add(tfSend);

		// 将发送按钮添加进去
		panelButtom.add(btSend);

		// 将上面板加入到框架中 位置 北
		frame.add(panelTop, BorderLayout.NORTH);

		// 将中面板添加到框架中，位置 中间
		frame.add(panelMinddle, BorderLayout.CENTER);

		// 将下面板添加到面板中，位置 南
		frame.add(panelButtom, BorderLayout.SOUTH);

		// 设置窗体大小
		frame.setSize(300, 200);

		// 设置窗体是否可见
		frame.setVisible(true);
		
		//设置最大化按钮不可用
		frame.setResizable(false);
		
		// 设置位置
		frame.setLocation(100, 500);

		// 设置框架的窗体监听器
		frame.addWindowListener(this);

		// 设置按钮的窗体监听器
		btConfirm.addActionListener(this);

		// 设置按钮的窗体监听器
		btSend.addActionListener(this);

	}

	/**
	 * (non-Javadoc) 窗体关闭事件
	 * 
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent e) {

		// 关闭接收的socket
		receiveSocket.close();

		// 关闭发送的socket
		sendSocket.close();

		// 程序退出
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

	// 开始方法
	public void start() {
		try {
			// 客户机发送端口
			sendSocket = new DatagramSocket(5000);
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	/**
	 * 接收消息
	 */
	public void receiveMessage() {
		try {
			// 客户机接收端口
			receiveSocket = new DatagramSocket(3000);

			while (true) {

				// 缓存区
				byte[] buf = new byte[200];

				// 拆包
				receivePacket = new DatagramPacket(buf, buf.length);

				// 接收
				receiveSocket.receive(receivePacket);

				if (receivePacket.getLength() == 0) {
					ta.append("空消息" + "\n");
					continue;
				}
				// 字节数组转换流
				ByteArrayInputStream bin = new ByteArrayInputStream(receivePacket.getData());

				// 字符缓冲区
				BufferedReader read = new BufferedReader(new InputStreamReader(bin));

				// 按行读取
				ta.append("服务器:" + read.readLine());

				// 换行
				ta.append("\n");

				// 关闭读对象
				read.close();

				// 关闭字符数组流
				bin.close();
			}
		} catch (Exception e) {
			ta.append(e + "sendmessage error\n");
		}
	}

	/**
	 * 发送消息
	 */
	public void sendMessage() {
		try {

			// 得到文本
			String s = tfSend.getText();

			// 赋空值
			tfSend.setText("");

			// 追加
			ta.append("客户机:" + s);

			ta.append("\n");

			// 字节数组输出流
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			// 打印流
			PrintStream pout = new PrintStream(out);

			// 打印
			pout.print(s);

			// 转换为字节数组
			byte[] buf = out.toByteArray();

			// 装包
			sendPacket = new DatagramPacket(buf, buf.length, InetAddress.getByName(ip), 4000);

			// 发送
			sendSocket.send(sendPacket);

			// 等待JVM处理
			buf = null;
		} catch (Exception e) {
			ta.append(e + "\n");
		}
	}

	/**
	 * (non-Javadoc) 按钮事件
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		// 点击发送按钮
		if (e.getSource() == btSend) {

			// 发送消息
			sendMessage();

			// 点击确定按钮
		} else if (e.getSource() == btConfirm) {

			// 赋值ip
			ip = tfIP.getText();

			// 清空显示
			tfIP.setText("");
		}
	}
}
