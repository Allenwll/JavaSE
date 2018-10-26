package acer.allen.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		// 创建一个File对象
		// "./"当前目录
		// "../"上级目录
		String path = "D:/Allen/Android/笔记/Java基础";
		// String path1="D:\\Allen\\Android\\笔记\\Java基础";
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
	 * 得到当前文件夹下所有的文件
	 */
	static void showFiles(String path) {
		File file = new File(path);
		if (file.exists()) {// 是否存在文件
			if (file.isDirectory()) {// 是否是文件夹
				File[] files = file.listFiles();// 实例化
				for (int i = 0; i < files.length; i++) {
					showFiles(files[i].getAbsolutePath());// 递归
				}
			} else {
				System.out.println(file.getName());
				return;
			}
		}
	}

	/**
	 * 打印指定文件夹下所有文件和文件夹
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
	 * 使用 创建目录，在目录下创建文件 再更改后缀名
	 */
	static void test(String path, int len) {
		
		try {
			// 实例化
			File f = new File(path);
			// 创建目录
			if (!f.exists()) {
				f.mkdir();
			}
			// 创建文件
			for (int i = 0; i < len; i++) {
				File file = new File(path + "/" + i + ".txt");
				if (!file.exists()) {
					file.createNewFile();
				}
				// 重命名
				File file1 = new File(path + "/" + i + ".java");
				file.renameTo(file1);
				// 删除源文件
				file.delete();
				file=null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
