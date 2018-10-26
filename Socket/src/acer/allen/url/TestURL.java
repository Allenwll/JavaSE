package acer.allen.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

/**
 * URL 类 统一资源定位符 uniform resource locator
 * 
 * @author acer
 *
 */
public class TestURL {
	public static void main(String[] args) throws IOException {

		// 初始化URL类 传递一个具体网页
		URL url = new URL("http://tool.liuxue86.com/shici_view_9b900943ac9b9009/");

		// 打印该网页地址
		System.out.println(url);

		// 得到端口
		System.out.println("端口:" + url.getPort());

		// 得到主机
		System.out.println("主机:" + url.getHost());

		// 得到路径
		System.out.println("路径:" + url.getPath());

		// 得到文件
		System.out.println("文件" + url.getFile());

		// 得到传输协议
		System.out.println("协议:" + url.getProtocol());

		// 方式
		System.out.println("参数部分:" + url.getQuery());
		// 域名
		System.out.println("域名：" + url.getAuthority());

		// 默认端口
		System.out.println("默认端口:" + url.getDefaultPort());

		// 引用
		System.out.println("锚点：" + url.getRef());

		// 用户信息
		System.out.println("userInfo:" + url.getUserInfo());

		// 字符转换流读取:
		InputStreamReader isr = new InputStreamReader(url.openStream(), "utf-8");

		// 字符缓冲区 输入流
		BufferedReader br = new BufferedReader(isr);

		// 字符缓冲输出流
		BufferedWriter bw = new BufferedWriter(new FileWriter("news.txt"));

		// 字符打印流
		PrintWriter pw = new PrintWriter("news.html", "UTF-8");

		// 行读取
		String str = br.readLine();
		while (true) {
			// 判断是否读取到末尾
			if (str == null) {
				break;
			}
			
			// 打印
			System.out.println(str);
			
			// 写入
			pw.write(str);
			
			// 写入
			bw.write(str);
			
			// 换行
			bw.newLine();
			
			// 读取下一行
			str = br.readLine();
		}
		// 关闭输入流
		br.close();
		
		// 关闭输出流
		bw.close();
		
		// 关闭输出流
		pw.close();
	}

}
