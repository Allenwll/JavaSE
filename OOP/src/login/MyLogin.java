package login;

/**
 * 登录类 实现登录接口
 * 
 * @author acer
 *
 */
public class MyLogin implements Loginable {
	// 重写接口注册方法
	@Override
	public int registe(String name, String password) {
		if (name == null)
			return -2;
		if (password == null)
			return -3;
		if (hasUser(name))
			return -1;
		if (!isNameVaild(name))
			return -2;
		if (!isPasswordVaild(password))
			return -3;
		return 1;
	}

	/**
	 * 判断数据库中是否有该用户名
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasUser(String name) {
		//将数据库赋给类数组类型 users
		Users[] users = DataBase.USERS;
		//循环判断数组中用户名是否相等于所传形参
		for (int i = 0; i < users.length; i++) {
			if (users[i].getName().equals(name))
				return true;
		}
		return false;
	}

	/**
	 * 判断用户名的有效性
	 */
	private boolean isNameVaild(String name) {
		//得到形参的长度
		int len = name.length();
		//排除掉长度小于6或者大于10的情况
		if (len < 6 || len > 10)
			return false;
		//循环判断用户名中是否有不是字母的情况
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c < 'z'))
				return true;
		}
		return false;
	}

	/**
	 * 判断密码的有效性
	 */
	private boolean isPasswordVaild(String password) {
		int len = password.length();
		if (len < 6 || len > 10)
			return false;
		int count = getCharCount(password);
		if (count == 0 || count == len)
			return false;
		if (count + getNum(password) == len)
			return true;
		return false;
	}

	/**
	 * 判断字符串拥有几个字母
	 * 
	 * @param password
	 * @return
	 */
	private int getCharCount(String password) {
		int len = password.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			char c = password.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c < 'z'))
				count++;
		}
		return count;
	}

	/**
	 * 判断字符串拥有几个数字
	 * 
	 * @param str
	 * @return
	 */
	private int getNum(String str) {
		int len = str.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9')
				count++;
		}
		return count;
	}

	/**
	 * 登录
	 */
	@Override
	public int login(String name, String password) {
		if (!hasUser(name))
			return -1;
		if (!hasPwd(password))
			return -2;
		return 1;
	}

	/**
	 * 密码
	 */
	private boolean hasPwd(String pwd) {
		Users[] user = DataBase.USERS;
		for (int i = 0; i < user.length; i++) {
			if (user[i].getPassword().equals(pwd))
				return true;
		}
		return false; 
	}

}
