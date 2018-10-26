package actor;

public class Actor implements PlayMovie, PlayTV, Sing {
	private String name;

	public Actor(String name) {
		this.name = name;
		System.out.println("大家好！我是" + this.name);
	}

	public void sing() {
		System.out.println("我会唱歌!");

	}

	@Override
	public void playTV() {
		System.out.println("我会演电视剧！");
	}

	@Override
	public void playMovie() {
		System.out.println("我能演电影！");
	}

}
