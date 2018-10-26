package acer.allen;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws UnknownHostException {
		// �õ�����IP��������
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("������IP��ַ������:"+address);
		// �õ�����IP
		System.out.println("����IP��ַ:"+address.getHostAddress());
		// �õ���������
		System.out.println("������������:"+address.getHostName());
		// �����δת����IP��ַ  �ֽ�127 �������
		System.out.println("����δת����IP��ַ:"+Arrays.toString(address.getAddress()));

		// ͨ�������õ���ַ
		System.out.println(address.getByName("www.baidu.com"));
		
		// ͨ�������õ�IP
		address = InetAddress.getByName("127.0.0.1");
		System.out.println(address.getCanonicalHostName());
		System.out.println(Arrays.toString(address.getAddress()));
		
		System.out.println(address.getHostAddress());
		
		System.out.println(address.getHostName());
		
		System.out.println(InetAddress.getLoopbackAddress());
		// �õ�IP
		
		

	}

}
