package acer.allen.stream.iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("./1.txt");
		String s="���ʹ���δ���ڣ��������ӻ��˼�\n ��������������,��ʽ��̢���ȱ�\nС¥��ҹ�ֶ��磬����ţ������\n"+
		"������ֻ�����,��̳���ţ����\n����������ѻ,�յ�WIFI����\nһ�����һ���,�ϰ�����������\n�һ�̶ˮ��ǧ��,��Ҫ��Ҫ����ʺ��";
		byte[] b=s.getBytes();
		/*
		 * for (int i = 0; i < b.length; i++) { fos.write(b[i]); }
		 */
		fos.write(b);
		fos.close();
	}
}
