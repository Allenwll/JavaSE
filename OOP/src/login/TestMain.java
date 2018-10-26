package login;

/**
 * 入口类
 * 
 * @author acer
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// 实例化登录类
		MyLogin mylogin = new MyLogin();
		// 调用注册方法
		myLogin(mylogin, "sxtAllen", "Allen124");
		// 调用登录方法
		login(mylogin, "sxtAllen", "Allen124");

	}

	/**
	 * 多态 注册方法
	 * 
	 * @param login
	 *            实参子类 形参 接口
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 */
	static void myLogin(Loginable login, String name, String pwd) {
		// 得到该子类的注册方法返回的值
		int result = login.registe(name, pwd);
		switch (result) {
		case -1:
			System.out.println("用户名已被注册！");
			break;
		case -2:
			System.out.println("用户名无效!");
			break;
		case -3:
			System.out.println("密码无效!");
			break;
		case 1:
			System.out.println("注册成功！");
			break;
		}
	}

	/**
	 * 多态 登录方法
	 * 
	 * @param login
	 *            实参子类 形参 接口
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 */
	static void login(Loginable login, String name, String password) {
		int result = login.login(name, password);
		switch (result) {
		case -1:
			System.out.println("用户名错误！");
			break;
		case -2:
			System.out.println("密码错误！");
			break;
		case 1:
			System.out.println("登录成功！");
			break;
		}
	}

}
