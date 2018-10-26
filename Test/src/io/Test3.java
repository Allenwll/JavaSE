package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * �ļ��и���
 * 
 * author Allen
 * 
 * date 2018 2018��4��27�� ����9:21:33
 */
public class Test3 {

	public static void main(String[] args) {

	}

	/**
	 * ����Ŀ¼
	 * 
	 * @param sourceDir
	 *            ԴĿ¼
	 * @param targetDir
	 *            Ŀ��Ŀ¼
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private static void copyDirectory(String sourceDir, String targetDir) throws IOException {

		// ���ԴĿ¼
		File fSourceDir = new File(sourceDir);
		if (!fSourceDir.exists() || !fSourceDir.isDirectory()) {
			return;
		}
		// ���Ŀ��Ŀ¼,�������򴴽�
		File fTargetDir = new File(targetDir);
		if (!fTargetDir.exists()) {
			fTargetDir.mkdirs();
		}

		// ����ԴĿ¼�µ��ļ���Ŀ¼
		File[] file = fSourceDir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// Դ�ļ�
				File sourceFile = file[i];
				// Ŀ���ļ�
				File targetFile = new File(fTargetDir, file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			// �ݹ鸴����Ŀ¼
			if (file[i].isDirectory()) {
				// ׼�����Ƶ�Դ�ļ���
				String subSourceDir = sourceDir + File.separator + file[i].getName();
				// ׼�����Ƶ�Ŀ���ļ���
				String subTargetDir = targetDir + File.separator + file[i].getName();
				// ������Ŀ¼
				copyDirectory(subSourceDir, subTargetDir);
			}
		}
	}

	/**
	 * ���Ƶ����ļ�
	 * 
	 * @param sourceFile
	 *            Դ�ļ�
	 * @param targetFile
	 *            Ŀ���ļ�
	 * @throws IOException 
	 */
	private static void copyFile(File sourceFile, File targetFile) throws IOException {
		// TODO Auto-generated method stub

		BufferedInputStream inBuffer = null;
		BufferedOutputStream outBuffer = null;
			// �½��ļ�������
			inBuffer = new BufferedInputStream(new FileInputStream(sourceFile));
			// �½��ļ������
			outBuffer = new BufferedOutputStream(new FileOutputStream(targetFile));
			// ��������
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuffer.read(b)) != -1) {
				outBuffer.write(b,0,len);
			}
			//ˢ��
			outBuffer.flush();
		
			//�ر���
			if(inBuffer!=null){
				inBuffer.close();
			}
			if(outBuffer!=null){
				outBuffer.close();
			
		}

	}

}
