package acer.allen.file;

import java.io.File;

/**
 * ��ӡ�����ļ�
 * 
 * @author acer
 *
 */
public class Test1 {

	public static void main(String[] args) {
		// ʵ�����ļ�
		File f = new File("../Wrapper");

		// ��ӡ�����ļ�
		printFile(f);

		// ��ӡ�����ļ���
		printDir(f);

		// ��ӡ�����ļ����ļ���
		printAll(new File("../Wrapper"), 1);

	}

	/**
	 * ��ӡ�����ļ�
	 * 
	 * @param f
	 *            �ļ���
	 * @param tab
	 *            ���Ʋ��
	 */
	static void printAll(File f, int tab) {
		// ���������ļ����ļ���
		if (f.isDirectory()) {
			// �õ��ļ����������ļ�����
			File[] next = f.listFiles();
			for (int i = 0; i < next.length; i++) {
				for (int j = 0; j < tab; j++) {
					// ���Ʋ��
					System.out.print("|--");
				}
				// ��ӡ����
				System.out.println(next[i].getName());
				if (next[i].isDirectory()) {
					// ������ӡ
					printAll(next[i], tab + 1);
				}
			}
		}
	}

	/**
	 * ��ӡ�����ļ�
	 * 
	 * @param f
	 */
	static void printFile(File f) {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					System.out.println(file.getName());
				} else {
					printFile(file);
				}
			}
		}
	}

	/**
	 * ��ӡ�����ļ���
	 * 
	 * @param f
	 */
	static void printDir(File f) {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					printFile(file);
				} else {
					System.out.println(file.getName());
				}
			}
		}
	}
}
