package net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 * ����ģʽ
 * 
 * ����ģʽ
 * 
 * @author acer
 *
 */
public class ChatManager {

	// ����
	Vector<ChatSocket> vector = new Vector<ChatSocket>();

	private ChatManager() {
	}

	// �ڲ�ʵ��������
	private static final ChatManager cm = new ChatManager();

	public static ChatManager getChatManager() {
		return cm;
	}

	// ���
	public void add(ChatSocket cs) {
		vector.add(cs);
	}

	/**
	 * ���
	 * 
	 * @param cs
	 * @param out
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void publish(ChatSocket cs, String out) throws UnsupportedEncodingException, IOException {
		// ������ʾ
		for (int i = 0; i < vector.size(); i++) {

			ChatSocket csChatSocket = vector.get(i);
			
			//System.out.println(cs + "====" + csChatSocket);
			
			if (!cs.equals(csChatSocket)) {
				// ������Ϣ
				csChatSocket.out(out);
			}
		}

	}
}
