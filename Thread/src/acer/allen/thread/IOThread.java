package acer.allen.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件读写线程
 * 
 * @author acer
 *
 */
public class IOThread {
	/**
	 * 程序的入口
	 * 
	 * @param args
	 *            参数
	 * @throws IOException
	 *             IO流异常
	 */
	public static void main(String[] args) throws IOException {
		// 文件路径
		File file = new File("一棵开花的树.txt");

		// 初始化写线程
		WriteThread wt = new WriteThread(file);

		// 开启写线程
		new Thread(wt).start();
		try {
			// 休眠3秒
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 初始化读线程
		ReadThread rt = new ReadThread(file);

		// 开启读线程
		new Thread(rt).start();
	}
}

/**
 * 写线程
 * 
 * @author acer
 *
 */
class WriteThread implements Runnable {

	// 文件对象
	File file = null;

	/**
	 * 构造方法
	 * 
	 * @param file
	 *            传递一个文件对象
	 */
	public WriteThread(File file) {
		super();
		this.file = file;
	}

	/**
	 * 实现Runnable接口的run方法 线程体的所在
	 */
	@Override
	public void run() {
		// 同步锁
		synchronized (file) {
			// 转换流
			InputStreamReader isr = new InputStreamReader(System.in);
			// 字符缓冲读取流
			BufferedReader br = new BufferedReader(isr);
			// 字符缓冲写入流
			BufferedWriter bw = null;
			System.out.print("请输入您想要的数据:");
			System.err.println("(输入exit退出)");
			try {
				// 初始化
				bw = new BufferedWriter(new FileWriter(file));
				// 按行读取
				String str = br.readLine();
				// 读到exit 结束接收
				while (!str.equals("exit")) {
					// 按行写入
					bw.write(str);
					// 换行
					bw.newLine();
					// 开始下一行读取
					str = br.readLine();
				}
				// 关闭写入流
				bw.close();
				// 关闭读取流
				br.close();
				System.err.println("------------开始写入文件-------------");
				// 线程休眠2秒
				Thread.sleep(2000);
				System.err.println("\n\t\t写入完成\t\t\n");
				// 休眠一秒
				Thread.sleep(1000);
				System.err.println("-------------开始读取文件---------------");
				// 休眠2秒
				Thread.sleep(2000);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

/**
 * 读取线程
 * 
 * @author acer
 *
 */
class ReadThread implements Runnable {
	// file对象
	File file = null;

	/**
	 * 构造方法
	 * 
	 * @param file
	 */
	public ReadThread(File file) {
		this.file = file;
	}

	@Override
	public void run() {
		// 定义读取缓冲流
		BufferedReader br = null;
		// 同步锁
		synchronized (file) {
			try {
				// 休眠2秒
				Thread.sleep(2000);
				// 初始化
				br = new BufferedReader(new FileReader(file));
				// 读取一行
				String str = br.readLine();
				while (true) {
					// 读取到最后结束读取
					if (str == null) {
						break;
					}
					// 打印读取到的内容
					System.out.println(str);
					// 休眠2秒
					Thread.sleep(2000);
					// 读取下一行
					str = br.readLine();
				}
				System.err.println("\n\t\t读取完成\t\t\n");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
