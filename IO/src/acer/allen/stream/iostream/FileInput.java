package acer.allen.stream.iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("./1.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		readFile(file);
	}

	static void readFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[fis.available()];
		// 一次性数据读取
		fis.read(b);
		fis.close();
		String str = new String(b);
		System.out.println(str);
	}
	@SuppressWarnings("resource")
	static void readFileContent(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		int i = 0;
		while ((i = fis.read()) != -1) {
			System.err.println((char) i);
		}
	}
}
