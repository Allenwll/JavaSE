package login;

public class Users {
	// ����
	private String name;
	// ����
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//���췽��
	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	//��д��toString����
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + "]";
	}

}
