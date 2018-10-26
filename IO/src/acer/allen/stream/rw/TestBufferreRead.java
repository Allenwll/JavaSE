package acer.allen.stream.rw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferreRead {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("5.txt"));
		String len = null;
		while (true) {
			len = br.readLine();
			if (len == null)
				break;
			bw.write(len);
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
