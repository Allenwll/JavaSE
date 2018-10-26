package acer.allen.stream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestScanner {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("8.txt"));
		Scanner scan = new Scanner(System.in);
		if (scan.hasNextInt()) {
			dos.writeInt(scan.nextInt());
		} else if (scan.hasNextBoolean()) {
			dos.writeBoolean(scan.nextBoolean());
		} else if (scan.hasNextLine()) {
			dos.writeUTF(scan.nextLine());
		} else if (scan.hasNextDouble()) {
			dos.writeDouble(scan.nextDouble());
		}
		scan.close();
	}
}
