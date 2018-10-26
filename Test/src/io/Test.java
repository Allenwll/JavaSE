package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws Exception {
		//直接拷贝
		copy();
		System.out.println("----------------------------");
		//缓冲区
		copyBuffer();
	}

	static void copy() throws Exception {
		long time=System.currentTimeMillis();
		// 实例化文件输入流
		FileInputStream fis = new FileInputStream("E:\\Movie\\红气球.mkv");
		//实例化文件输出流
		FileOutputStream fos = new FileOutputStream("E:RedBalloon.mp4");
		//定义字节数组
		byte[] buf = new byte[fis.available()];
		//读入操作
		fis.read(buf);
		//写出操作
		fos.write(buf);
		//关闭流
		fis.close();
		//关闭流
		fos.close();
		System.out.println("耗时："+(System.currentTimeMillis()-time));
	}
	static void copyBuffer() throws IOException{
		long time=System.currentTimeMillis();
		//实例化 
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("E:\\Movie\\红气球.mkv"));
		//实例化
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E:RedBalloon1.mp4"));
		byte[] buf=new byte[bis.available()];
		bis.read(buf);
		bos.write(buf);
		bos.flush();
		bis.close();
		bos.close();
		System.out.println("耗时："+(System.currentTimeMillis()-time));
	}
}
