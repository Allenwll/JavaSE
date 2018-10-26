package acer.allen.stringbuffer;

public class Test1 {
	public static void main(String[] args) {
		/*****************************************/
		System.out.println("\t千年之恋\n");
		showSong();
	}

	public static void showSong() {
		String songStr = "谁在悬崖沏一壶茶,温热前世的牵挂,而我在调整千年的时差,爱恨全喝下,岁月在岩石上敲打,我又留长了头发,耐心等待海岸线的变化,大雨就要下"
				+ "风 狠狠的刮,谁 在害怕,海风一直眷恋着沙,你却错过我的年华,错过我新长的枝丫,和我的白发,蝴蝶依旧狂恋着花,你却错过我的年华,错过我转世的脸颊,你还爱我吗,我等你一句话,"
				+ "一生行走望断天崖,最远不过是晚霞,而你今生又在哪户人家,欲语泪先下,沙滩上消失的浪花,让我慢慢想起家,曾经许下的永远又在哪,总是放不下,啊 轮回的记忆在风化,我将它牢牢记下,"
				+ "海风一直眷恋着沙,你却错过我的年华,错过我新长的枝丫,和我的白发,蝴蝶依旧狂恋着花,你却错过我的年华,错过我转世的脸颊,你还爱我吗,我等你一句话";
		String[] songs = songStr.split(",");
		int maxLen = 0;
		for (int i = 0; i < songs.length; i++) {
			int len = songs[i].length();
			if (len > maxLen)
				maxLen = len;
		}
		for (int i = 0; i < songs.length; i++) {
			int len=songs[i].length();
			for (int j = 0; j < (maxLen-len); j++) {
				System.out.print("  ");
			}
			System.out.println(songs[i]);
		}
	}
}