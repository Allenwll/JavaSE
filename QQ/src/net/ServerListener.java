package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������
 * 
 * @author acer
 *
 */
public class ServerListener extends Thread {
	// 1-65535
	@Override
	public void run() {
		try {
			// ָ������������˿�
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(8000);

			// ��ʾ
			System.err.println("-----------------�ȴ�����-------------------------");
			while (true) {
				
				// ��������
				Socket socket = server.accept();

				// ��ʾ
				System.out.println("���ӳɹ���");
				//JOsptionPane.showMessageDialog(null, "�пͻ������ӵ��˱�����8000�˿�");
				
				
				// ��socket���ݸ��µ��߳�
				ChatSocket cs = new ChatSocket(socket);
				
				//�����߳�
				cs.start();

				//����ģʽ���
				ChatManager.getChatManager().add(cs);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
