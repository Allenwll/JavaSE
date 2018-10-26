package acer.allen.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		// ����һ��File����
		// "./"��ǰĿ¼
		// "../"�ϼ�Ŀ¼
		String path = "D:/Allen/Android/�ʼ�/Java����";
		// String path1="D:\\Allen\\Android\\�ʼ�\\Java����";
		/*
		 * File file = new File(path); if (file.isDirectory()) { File[] files =
		 * file.listFiles(); for (int i = 0; i < files.length; i++) {
		 * System.out.println(files[i].getName()); } }
		 */
		showFiles("./");
		File f = new File("D:/Allen");
		printFileTree(f);
		test("E:/301", 10);

	}

	/**
	 * �õ���ǰ�ļ��������е��ļ�
	 */
	static void showFiles(String path) {
		File file = new File(path);
		if (file.exists()) {// �Ƿ�����ļ�
			if (file.isDirectory()) {// �Ƿ����ļ���
				File[] files = file.listFiles();// ʵ����
				for (int i = 0; i < files.length; i++) {
					showFiles(files[i].getAbsolutePath());// �ݹ�
				}
			} else {
				System.out.println(file.getName());
				return;
			}
		}
	}

	/**
	 * ��ӡָ���ļ����������ļ����ļ���
	 * 
	 * @param file
	 * @param level
	 */
	static void printFileTree(File file) {
		System.out.println("-----------------------");
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				printFileTree(f);
			}
		}
	}

	/**
	 * ʹ�� ����Ŀ¼����Ŀ¼�´����ļ� �ٸ��ĺ�׺��
	 */
	static void test(String path, int len) {
		
		try {
			// ʵ����
			File f = new File(path);
			// ����Ŀ¼
			if (!f.exists()) {
				f.mkdir();
			}
			// �����ļ�
			for (int i = 0; i < len; i++) {
				File file = new File(path + "/" + i + ".txt");
				if (!file.exists()) {
					file.createNewFile();
				}
				// ������
				File file1 = new File(path + "/" + i + ".java");
				file.renameTo(file1);
				// ɾ��Դ�ļ�
				file.delete();
				file=null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
