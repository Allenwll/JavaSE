package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �ͻ���
 * 
 * @author acer
 *
 */
public class Client {
	/**
	 * ��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// �ͻ���
		Socket socket = null;

		// ��ȡ������
		BufferedReader br = null;

		try {

			// ָ�������IP��ַ�Ͷ˿ں�
			socket = new Socket("LocalHost", 8080);

			// �������������߳�
			new ClientThread(socket).start();

			// ʵ����������
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// ����ѭ��
			while (true) {
					
				// bye �˳�
				if (br.readLine().equals("bye")) {

					// ��ʾ
					System.err.println("Server Over this meeting .");

					// �˳�
					System.exit(0);
				}
				
				System.out.println("��������˵��" + br.readLine());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر�������
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// �ر�socket�׽���
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * ���������߳�
 * 
 * @author acer
 *
 */
class ClientThread extends Thread {

	// ʵ�����׽��ֶ���
	Socket socket;

	// �ַ�������
	BufferedReader br;

	// ��ӡ��
	PrintWriter out;

	public ClientThread(Socket socket) throws IOException {
		this.socket = socket;

		// ʵ�������Զ�ˢ��
		out = new PrintWriter(socket.getOutputStream(), true);

		// ���տ���̨����
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	@Override
	public void run() {

		// ��ʾ
		System.out.println("��������Ҫ˵�Ļ���");
		try {
			// ѭ������
			while (true) {

				// ���ж�ȡ
				String str = br.readLine();

				// д����
				out.write(str + "\n");

				// ˢ��
				out.flush();

				// ����bye �˳�����
				if (str.equals("bye")) {
					System.err.println("Client stop this meeting !");
					// �����˳�
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر���
				out.close();
				br.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
