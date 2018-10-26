package actor;

public class Actor implements PlayMovie, PlayTV, Sing {
	private String name;

	public Actor(String name) {
		this.name = name;
		System.out.println("��Һã�����" + this.name);
	}

	public void sing() {
		System.out.println("�һᳪ��!");

	}

	@Override
	public void playTV() {
		System.out.println("�һ��ݵ��Ӿ磡");
	}

	@Override
	public void playMovie() {
		System.out.println("�����ݵ�Ӱ��");
	}

}
