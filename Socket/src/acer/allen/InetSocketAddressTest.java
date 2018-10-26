package acer.allen;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressTest {

	public static void main(String[] args) {
		InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 8080);
		InetAddress address = socketAddress.getAddress();
		System.out.println("得到IP地址:"+address.getHostAddress());
		System.out.println("得到主机名字:" + socketAddress.getHostName());
		System.out.println("得到端口号:" + socketAddress.getPort());
		System.out.println("得到HostString:" + socketAddress.getHostString());
	}

}
