package acer.allen.stream.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDir {
	public static File dirFrom;
	public static File dirTo;

	// Ŀ��·�������ļ���
	public static void listFileInDir(File file) {
		File[] files = file.listFiles();
		for (File f : files) {
			String tempfrom = f.getAbsolutePath();
			String tempto = tempfrom.replace(dirFrom.getAbsolutePath(), dirTo.getAbsolutePath()); // �����·�� �滻ǰ���·����
			if (f.isDirectory()) {
				File tempFile = new File(tempto);
				tempFile.mkdirs();
				listFileInDir(f);
				
			} else {
				System.out.println("Դ�ļ�:" + f.getAbsolutePath());
				//
				int endindex = tempto.lastIndexOf("\\");// �ҵ�"/"���ڵ�λ��
				String mkdirPath = tempto.substring(0, endindex);
				File tempFile = new File(mkdirPath);
				tempFile.mkdirs();// �����ļ���
				System.out.println("Ŀ���:" + tempto);
				copy(tempfrom, tempto);
			}
		}
	}

	/**
	 * ��װ�õ��ļ���������
	 */
	public static void copy(String from, String to) {
		try {

			InputStream in = new FileInputStream(from);
			OutputStream out = new FileOutputStream(to);

			/*
			 * byte[] buff = new byte[1024]; int len = 0; while ((len =
			 * in.read(buff)) != -1) { out.write(buff, 0, len); }
			 */
			byte[] buff = new byte[in.available()];
			in.read(buff);
			out.write(buff);
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File fromfile = new File("d:\\sxtjava");// Դ�ļ���
		File tofile = new File("d:\\sxtjava2");// Ŀ��
		CopyDir.dirFrom = fromfile;
		CopyDir.dirTo = tofile;
		listFileInDir(fromfile);
	}
}
