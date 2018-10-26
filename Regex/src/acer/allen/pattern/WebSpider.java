package acer.allen.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫
 * 
 * @author acer
 *
 */
public class WebSpider {

	public static void main(String[] args) throws IOException {

		// 统一资源定位符
		URL url = new URL("http://tieba.baidu.com/p/496274307");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String len=br.readLine();
		Pattern p = Pattern.compile("[\\w[.]]+@[\\w[.]]+\\.[\\w]+");
		while (len!= null) {
			Matcher m = p.matcher(len);
			while(m.find()){
				System.out.println(m.group());
			}
			len = br.readLine();
		}
		br.close();
	}

}
