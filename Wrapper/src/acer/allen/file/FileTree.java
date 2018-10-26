package acer.allen.file;

import java.io.File;

public class FileTree {

	public static void main(String[] args) {
		File f = new File("D:/Allen");
		printFile(f,0);
	}

	 static void printFile(File file, int level) {
		for (int i = 0; i < level; i++) {
			System.out.println("-");
		}
		System.out.println(file.getName());
		if(file.isDirectory()){
			File[] files=file.listFiles();
			for (File temp : files) {
				printFile(temp,level+1);
			}
		}
	}

}
