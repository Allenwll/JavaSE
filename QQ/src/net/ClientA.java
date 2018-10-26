package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * �ͻ���A
 * 
 * @author acer
 *
 */
public class ClientA {

	/**
	 * �������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// �����ͻ��˶���
		Socket socket = null;

		BufferedReader br = null;
		try {
			// ָ�����Ӷ˿ں�IP��ַ
			socket = new Socket("LocalHost", 8000);

			// �������������߳�
			new SendThread(socket).start();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.equals("bye")) {
					System.err.println("�����Ự��");
					System.exit(0);
				}
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * ������Ϣ�߳�
 * 
 * @author acer
 *
 */
class SendThread extends Thread {

	// �ͻ��˶���
	Socket socket = null;

	// �ַ����������
	BufferedReader br = null;

	// �ַ�����д����
	BufferedWriter bw = null;

	public SendThread(Socket socket) throws IOException {

		this.socket = socket;

		// ʵ����������
		br = new BufferedReader(new InputStreamReader(System.in));

		// ʵ����д����
		bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
	}

	@Override
	public void run() {
		// ��ʾ
		System.err.println("����������Ҫ˵�Ļ�:");

		// ѭ����ȡ
		while (true) {
			try {

				// ���ж�ȡ
				String temp = br.readLine();

				System.out.println("��˵:" + temp);
				// д��
				bw.write("A˵:" + temp);

				bw.newLine();

				// ˢ��
				bw.flush();

				// �ж��Ƿ�����bye
				if (temp.equals("bye")) {

					System.out.println("��ֹ�Ự.");
					// �˳�����
					System.exit(0);
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {

			// �ر�������
			bw.close();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}