package net;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

/**
 * 单例模式
 * 
 * 饿汉模式
 * 
 * @author acer
 *
 */
public class ChatManager {

	// 集合
	Vector<ChatSocket> vector = new Vector<ChatSocket>();

	private ChatManager() {
	}

	// 内部实例化对象
	private static final ChatManager cm = new ChatManager();

	public static ChatManager getChatManager() {
		return cm;
	}

	// 添加
	public void add(ChatSocket cs) {
		vector.add(cs);
	}

	/**
	 * 添加
	 * 
	 * @param cs
	 * @param out
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void publish(ChatSocket cs, String out) throws UnsupportedEncodingException, IOException {
		// 遍历显示
		for (int i = 0; i < vector.size(); i++) {

			ChatSocket csChatSocket = vector.get(i);
			
			//System.out.println(cs + "====" + csChatSocket);
			
			if (!cs.equals(csChatSocket)) {
				// 发送信息
				csChatSocket.out(out);
			}
		}

	}
}
