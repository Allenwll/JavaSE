package login;

public class Users {
	// 姓名
	private String name;
	// 密码
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
	//构造方法
	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	//重写的toString方法
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + "]";
	}

}
