package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������
 * 
 * @author acer
 *
 */
/**
 * @author acer
 *
 */
public class Server {

	/**
	 * ��������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// �����
		ServerSocket server = null;

		// �ͻ���
		Socket socket = null;

		// ������
		BufferedReader line = null;

		try {
			// ָ���˿ں�
			server = new ServerSocket(8080);

			// ��ʾ
			System.err.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^�ȴ��ͻ�������^^^^^^^^^^^^^^^^^^^^^^^^^^");

			// ���տͻ�������
			socket = server.accept();

			// ��ʾ
			System.out.println("�ͻ������ӳɹ���");

			// ���������߳�
			new ServerThread(socket).start();

			// ��ȡ
			line = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {

				String data = line.readLine();
				// bye �˳�
				if (data.equals("bye")) {

					// ��ʾ
					System.err.println("Client Over this meeting .");

					// �˳�
					System.exit(0);
				}

				// ��ʾ
				System.out.println("�ͻ���˵:" + data);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				// �ر���
				line.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// �ر��׽���
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				// �رշ�������
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * �����߳�
 * 
 * @author acer
 *
 */
class ServerThread extends Thread {

	// �ͻ���
	Socket socket;

	// ��
	BufferedReader br = null;

	// д
	BufferedWriter bw = null;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;

		// ����̨���ݶ���
		br = new BufferedReader(new InputStreamReader(System.in));

		// д��
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	}

	@Override
	public void run() {
		try {
			// ��ʾ
			System.out.println("��������Ҫ˵�Ļ�:");
			while (true) {

				// ���ж�ȡ
				String data = br.readLine();

				// д��
				bw.write(data + "\n");

				// ˢ��
				bw.flush();

				// bye �˳�
				if (data.equals("bye")) {

					// ��ʾ
					System.err.println("Server Over this meeting .");

					// �˳�
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// �ر���
				bw.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
