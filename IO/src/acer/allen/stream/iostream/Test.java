package acer.allen.stream.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {

		String str = "C:\\Users\\acer\\Pictures\\Saved Pictures\\2.png";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(str);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fos = new FileOutputStream("C:\\Users\\acer\\Desktop\\Flower.png");
			fos.write(b);
			//fos.flush(); Ç¿ÖÆË¢ÐÂ
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
