package acer.allen.stream.iostream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("./1.txt");
		String s="君问归期未有期，红烧茄子黄焖鸡\n 天若有情天亦老,葡式蛋挞伴腿堡\n小楼昨夜又东风，铁板牛肉煎洋葱\n"+
		"人生若只如初见,老坛酸菜牛肉面\n枯藤老树昏鸦,空调WIFI西瓜\n一寸光阴一寸金,老板再来串鸡心\n桃花潭水深千尺,你要不要来口屎！";
		byte[] b=s.getBytes();
		/*
		 * for (int i = 0; i < b.length; i++) { fos.write(b[i]); }
		 */
		fos.write(b);
		fos.close();
	}
}
