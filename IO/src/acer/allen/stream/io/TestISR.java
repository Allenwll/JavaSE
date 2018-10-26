package acer.allen.stream.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestISR {

	public static void main(String[] args) throws IOException {
			test1();
	}

	static void test1() throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("1.txt"));
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("4.txt")));

		String len = br.readLine();
		while (true) {
			if (len == null)
				break;
			bw.write(len);
			bw.newLine();
			len = br.readLine();
		}
		bw.flush();
		bw.close();
		isr.close();
	}

}
