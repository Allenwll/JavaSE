package acer.allen.file;

import java.io.File;

/**
 * 打印所有文件
 * 
 * @author acer
 *
 */
public class Test1 {

	public static void main(String[] args) {
		// 实例化文件
		File f = new File("../Wrapper");

		// 打印所有文件
		printFile(f);

		// 打印所有文件夹
		printDir(f);

		// 打印所有文件和文件夹
		printAll(new File("../Wrapper"), 1);

	}

	/**
	 * 打印所有文件
	 * 
	 * @param f
	 *            文件名
	 * @param tab
	 *            控制层次
	 */
	static void printAll(File f, int tab) {
		// 如果传入的文件是文件夹
		if (f.isDirectory()) {
			// 得到文件夹下所有文件集合
			File[] next = f.listFiles();
			for (int i = 0; i < next.length; i++) {
				for (int j = 0; j < tab; j++) {
					// 控制层次
					System.out.print("|--");
				}
				// 打印名字
				System.out.println(next[i].getName());
				if (next[i].isDirectory()) {
					// 遍历打印
					printAll(next[i], tab + 1);
				}
			}
		}
	}

	/**
	 * 打印所有文件
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
	 * 打印所有文件夹
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
