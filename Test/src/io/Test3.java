package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * 文件夹复制
 * 
 * author Allen
 * 
 * date 2018 2018年4月27日 下午9:21:33
 */
public class Test3 {

	public static void main(String[] args) {

	}

	/**
	 * 复制目录
	 * 
	 * @param sourceDir
	 *            源目录
	 * @param targetDir
	 *            目标目录
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private static void copyDirectory(String sourceDir, String targetDir) throws IOException {

		// 检查源目录
		File fSourceDir = new File(sourceDir);
		if (!fSourceDir.exists() || !fSourceDir.isDirectory()) {
			return;
		}
		// 检查目标目录,不存在则创建
		File fTargetDir = new File(targetDir);
		if (!fTargetDir.exists()) {
			fTargetDir.mkdirs();
		}

		// 遍历源目录下的文件或目录
		File[] file = fSourceDir.listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(fTargetDir, file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			// 递归复制子目录
			if (file[i].isDirectory()) {
				// 准备复制的源文件夹
				String subSourceDir = sourceDir + File.separator + file[i].getName();
				// 准备复制的目标文件夹
				String subTargetDir = targetDir + File.separator + file[i].getName();
				// 复制子目录
				copyDirectory(subSourceDir, subTargetDir);
			}
		}
	}

	/**
	 * 复制单个文件
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param targetFile
	 *            目标文件
	 * @throws IOException 
	 */
	private static void copyFile(File sourceFile, File targetFile) throws IOException {
		// TODO Auto-generated method stub

		BufferedInputStream inBuffer = null;
		BufferedOutputStream outBuffer = null;
			// 新建文件输入流
			inBuffer = new BufferedInputStream(new FileInputStream(sourceFile));
			// 新建文件输出流
			outBuffer = new BufferedOutputStream(new FileOutputStream(targetFile));
			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuffer.read(b)) != -1) {
				outBuffer.write(b,0,len);
			}
			//刷新
			outBuffer.flush();
		
			//关闭流
			if(inBuffer!=null){
				inBuffer.close();
			}
			if(outBuffer!=null){
				outBuffer.close();
			
		}

	}

}
