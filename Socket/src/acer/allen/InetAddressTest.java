package acer.allen;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws UnknownHostException {
		// 得到本机IP和主机名
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("本机的IP地址和名字:"+address);
		// 得到本机IP
		System.out.println("本机IP地址:"+address.getHostAddress());
		// 得到主机名字
		System.out.println("本机主机名字:"+address.getHostName());
		// 输出了未转换的IP地址  字节127 输出负数
		System.out.println("本机未转换的IP地址:"+Arrays.toString(address.getAddress()));

		// 通过域名得到地址
		System.out.println(address.getByName("www.baidu.com"));
		
		// 通过域名得到IP
		address = InetAddress.getByName("127.0.0.1");
		System.out.println(address.getCanonicalHostName());
		System.out.println(Arrays.toString(address.getAddress()));
		
		System.out.println(address.getHostAddress());
		
		System.out.println(address.getHostName());
		
		System.out.println(InetAddress.getLoopbackAddress());
		// 得到IP
		
		

	}

}
