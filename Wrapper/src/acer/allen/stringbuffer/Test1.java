package acer.allen.stringbuffer;

public class Test1 {
	public static void main(String[] args) {
		/*****************************************/
		System.out.println("\tǧ��֮��\n");
		showSong();
	}

	public static void showSong() {
		String songStr = "˭��������һ����,����ǰ����ǣ��,�����ڵ���ǧ���ʱ��,����ȫ����,��������ʯ���ô�,����������ͷ��,���ĵȴ������ߵı仯,�����Ҫ��"
				+ "�� �ݺݵĹ�,˭ �ں���,����һֱ������ɳ,��ȴ����ҵ��껪,������³���֦Ѿ,���ҵİ׷�,�������ɿ����Ż�,��ȴ����ҵ��껪,�����ת��������,�㻹������,�ҵ���һ�仰,"
				+ "һ��������������,��Զ��������ϼ,������������Ļ��˼�,����������,ɳ̲����ʧ���˻�,�������������,�������µ���Զ������,���ǷŲ���,�� �ֻصļ����ڷ绯,�ҽ������μ���,"
				+ "����һֱ������ɳ,��ȴ����ҵ��껪,������³���֦Ѿ,���ҵİ׷�,�������ɿ����Ż�,��ȴ����ҵ��껪,�����ת��������,�㻹������,�ҵ���һ�仰";
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