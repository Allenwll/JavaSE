package net;

import java.io.IOException;

/**
 * �����
 * 
 * @author acer
 *
 */
public class Server {

	/**
	 * �������
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
	
		// ��ʼ�߳�
		new ServerListener().start();
	}
}
