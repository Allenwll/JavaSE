package acer.allen.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

/**
 * URL �� ͳһ��Դ��λ�� uniform resource locator
 * 
 * @author acer
 *
 */
public class TestURL {
	public static void main(String[] args) throws IOException {

		// ��ʼ��URL�� ����һ��������ҳ
		URL url = new URL("http://tool.liuxue86.com/shici_view_9b900943ac9b9009/");

		// ��ӡ����ҳ��ַ
		System.out.println(url);

		// �õ��˿�
		System.out.println("�˿�:" + url.getPort());

		// �õ�����
		System.out.println("����:" + url.getHost());

		// �õ�·��
		System.out.println("·��:" + url.getPath());

		// �õ��ļ�
		System.out.println("�ļ�" + url.getFile());

		// �õ�����Э��
		System.out.println("Э��:" + url.getProtocol());

		// ��ʽ
		System.out.println("��������:" + url.getQuery());
		// ����
		System.out.println("������" + url.getAuthority());

		// Ĭ�϶˿�
		System.out.println("Ĭ�϶˿�:" + url.getDefaultPort());

		// ����
		System.out.println("ê�㣺" + url.getRef());

		// �û���Ϣ
		System.out.println("userInfo:" + url.getUserInfo());

		// �ַ�ת������ȡ:
		InputStreamReader isr = new InputStreamReader(url.openStream(), "utf-8");

		// �ַ������� ������
		BufferedReader br = new BufferedReader(isr);

		// �ַ����������
		BufferedWriter bw = new BufferedWriter(new FileWriter("news.txt"));

		// �ַ���ӡ��
		PrintWriter pw = new PrintWriter("news.html", "UTF-8");

		// �ж�ȡ
		String str = br.readLine();
		while (true) {
			// �ж��Ƿ��ȡ��ĩβ
			if (str == null) {
				break;
			}
			
			// ��ӡ
			System.out.println(str);
			
			// д��
			pw.write(str);
			
			// д��
			bw.write(str);
			
			// ����
			bw.newLine();
			
			// ��ȡ��һ��
			str = br.readLine();
		}
		// �ر�������
		br.close();
		
		// �ر������
		bw.close();
		
		// �ر������
		pw.close();
	}

}
