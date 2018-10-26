package acer.allen.stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDIS {
	/**
	 * 数据流
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		test();
		test1();
	}

	static void test() throws IOException {
		FileOutputStream fos = new FileOutputStream("6.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(87);
		dos.writeShort(2);
		dos.writeByte(1);
		dos.writeChar('7');
		dos.writeLong(5L);
		dos.writeDouble(6.6);
		dos.writeBoolean(true);
		dos.writeFloat(4.32f);
		dos.writeUTF("逆风如解意，容易莫摧残。");
		dos.writeUTF("梦里不知身是客，半缘修道半缘君");
		String s = "花非花，雾非雾，夜半来，天明去，来如春梦几多时，去似朝云无觅处！";
		dos.writeInt(s.length());
		dos.writeChars(s);
		dos.close();
	}

	static void test1() throws IOException {
		FileInputStream fis = new FileInputStream("6.txt");
		DataInputStream dis = new DataInputStream(fis);
		// 怎么写入的顺序，必须按照顺序读出
		System.out.println(dis.readInt());
		System.out.println(dis.readShort());
		System.out.println(dis.readByte());
		System.out.println(dis.readChar());
		System.out.println(dis.readLong());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readFloat());
		System.out.println(dis.readUTF());
		System.out.println(dis.readUTF());
		int len = dis.readInt();
		for (int i = 0; i < len; i++) {
			System.out.print(dis.readChar());
		}
		dis.close();
	}
}
