package test4;

public class News implements Comparable {
	
	private int num;
	private  String title;
	private String content;
	private int clickNo;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClickNo() {
		return clickNo;
	}

	public void setClickNo(int clickNo) {
		this.clickNo = clickNo;
	}

	public News(int num) {
		super();
		this.num = num;
	}
	

	@Override
	public String toString() {
		return "News [num=" + num + "]";
	}

	@Override
	public int compareTo(Object obj) {
			News news=(News) obj;
		return this.getNum()-news.getNum();
	}

}
