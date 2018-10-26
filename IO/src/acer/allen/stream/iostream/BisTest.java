package acer.allen.stream.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BisTest {
	public static void main(String[] args) {
		// ������ ������Ϊ�����Դͷ
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			// File f = new File("1.txt");
			// FileInputStream fs = new FileInputStream(f);
			// BufferedInputStream bis = new BufferedInputStream(fs);
			bis = new BufferedInputStream(new FileInputStream(new File("1.txt")));
			// �ֽڻ��������
			bos = new BufferedOutputStream(new FileOutputStream("4.txt"));
			byte[] b = new byte[bis.available()];
			int len = bis.read(b);
			while (len != -1) {
				// д��
				bos.write(b, 0, len);
				// �´ζ�ȡ
				len = bis.read(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
