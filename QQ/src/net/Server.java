package net;

import java.io.IOException;

/**
 * 服务端
 * 
 * @author acer
 *
 */
public class Server {

	/**
	 * 程序入口
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
	
		// 开始线程
		new ServerListener().start();
	}
}
