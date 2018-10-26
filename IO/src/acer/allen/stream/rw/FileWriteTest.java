package acer.allen.stream.rw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
	public static void main(String[] args) throws IOException {
		copyFile();

	}

	static void writerFile() throws IOException {
		FileWriter fw = new FileWriter("./1.txt", true);
		String s = "\n君问归期未有期，红烧茄子黄焖鸡\n 天若有情天亦老,葡式蛋挞伴腿堡\n小楼昨夜又东风，铁板牛肉煎洋葱\n"
				+ "人生若只如初见,老坛酸菜牛肉面\n枯藤老树昏鸦,空调WIFI西瓜\n一寸光阴一寸金,老板再来串鸡心";
		// fw.write(s);
		fw.append(s);
		fw.append(s);
		fw.flush();
		fw.close();

	}

	static void copyFile() throws IOException {
		FileReader fr = new FileReader("./1.txt");
		FileWriter fw = new FileWriter("C:\\Users\\acer\\Desktop\\2.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		while (true) {
			String len = br.readLine();
			if (len == null) {
				break;
			}
			bw.write(len);
		}
		br.close();
		fr.close();
		bw.close();
		fw.close();
	}
}
