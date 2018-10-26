package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws Exception {
		//ֱ�ӿ���
		copy();
		System.out.println("----------------------------");
		//������
		copyBuffer();
	}

	static void copy() throws Exception {
		long time=System.currentTimeMillis();
		// ʵ�����ļ�������
		FileInputStream fis = new FileInputStream("E:\\Movie\\������.mkv");
		//ʵ�����ļ������
		FileOutputStream fos = new FileOutputStream("E:RedBalloon.mp4");
		//�����ֽ�����
		byte[] buf = new byte[fis.available()];
		//�������
		fis.read(buf);
		//д������
		fos.write(buf);
		//�ر���
		fis.close();
		//�ر���
		fos.close();
		System.out.println("��ʱ��"+(System.currentTimeMillis()-time));
	}
	static void copyBuffer() throws IOException{
		long time=System.currentTimeMillis();
		//ʵ���� 
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("E:\\Movie\\������.mkv"));
		//ʵ����
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E:RedBalloon1.mp4"));
		byte[] buf=new byte[bis.available()];
		bis.read(buf);
		bos.write(buf);
		bos.flush();
		bis.close();
		bos.close();
		System.out.println("��ʱ��"+(System.currentTimeMillis()-time));
	}
}
