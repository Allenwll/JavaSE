package drink;

public abstract class Drink {
	// ��������
	private int volume;
	// ����
	private String name;

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public abstract void show();
}
