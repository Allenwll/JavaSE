package acer.allen;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressTest {

	public static void main(String[] args) {
		InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 8080);
		InetAddress address = socketAddress.getAddress();
		System.out.println("�õ�IP��ַ:"+address.getHostAddress());
		System.out.println("�õ���������:" + socketAddress.getHostName());
		System.out.println("�õ��˿ں�:" + socketAddress.getPort());
		System.out.println("�õ�HostString:" + socketAddress.getHostString());
	}

}
