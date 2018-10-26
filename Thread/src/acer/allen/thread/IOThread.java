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
 * �ļ���д�߳�
 * 
 * @author acer
 *
 */
public class IOThread {
	/**
	 * ��������
	 * 
	 * @param args
	 *            ����
	 * @throws IOException
	 *             IO���쳣
	 */
	public static void main(String[] args) throws IOException {
		// �ļ�·��
		File file = new File("һ�ÿ�������.txt");

		// ��ʼ��д�߳�
		WriteThread wt = new WriteThread(file);

		// ����д�߳�
		new Thread(wt).start();
		try {
			// ����3��
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ʼ�����߳�
		ReadThread rt = new ReadThread(file);

		// �������߳�
		new Thread(rt).start();
	}
}

/**
 * д�߳�
 * 
 * @author acer
 *
 */
class WriteThread implements Runnable {

	// �ļ�����
	File file = null;

	/**
	 * ���췽��
	 * 
	 * @param file
	 *            ����һ���ļ�����
	 */
	public WriteThread(File file) {
		super();
		this.file = file;
	}

	/**
	 * ʵ��Runnable�ӿڵ�run���� �߳��������
	 */
	@Override
	public void run() {
		// ͬ����
		synchronized (file) {
			// ת����
			InputStreamReader isr = new InputStreamReader(System.in);
			// �ַ������ȡ��
			BufferedReader br = new BufferedReader(isr);
			// �ַ�����д����
			BufferedWriter bw = null;
			System.out.print("����������Ҫ������:");
			System.err.println("(����exit�˳�)");
			try {
				// ��ʼ��
				bw = new BufferedWriter(new FileWriter(file));
				// ���ж�ȡ
				String str = br.readLine();
				// ����exit ��������
				while (!str.equals("exit")) {
					// ����д��
					bw.write(str);
					// ����
					bw.newLine();
					// ��ʼ��һ�ж�ȡ
					str = br.readLine();
				}
				// �ر�д����
				bw.close();
				// �رն�ȡ��
				br.close();
				System.err.println("------------��ʼд���ļ�-------------");
				// �߳�����2��
				Thread.sleep(2000);
				System.err.println("\n\t\tд�����\t\t\n");
				// ����һ��
				Thread.sleep(1000);
				System.err.println("-------------��ʼ��ȡ�ļ�---------------");
				// ����2��
				Thread.sleep(2000);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

/**
 * ��ȡ�߳�
 * 
 * @author acer
 *
 */
class ReadThread implements Runnable {
	// file����
	File file = null;

	/**
	 * ���췽��
	 * 
	 * @param file
	 */
	public ReadThread(File file) {
		this.file = file;
	}

	@Override
	public void run() {
		// �����ȡ������
		BufferedReader br = null;
		// ͬ����
		synchronized (file) {
			try {
				// ����2��
				Thread.sleep(2000);
				// ��ʼ��
				br = new BufferedReader(new FileReader(file));
				// ��ȡһ��
				String str = br.readLine();
				while (true) {
					// ��ȡ����������ȡ
					if (str == null) {
						break;
					}
					// ��ӡ��ȡ��������
					System.out.println(str);
					// ����2��
					Thread.sleep(2000);
					// ��ȡ��һ��
					str = br.readLine();
				}
				System.err.println("\n\t\t��ȡ���\t\t\n");
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
