package login;
/**
 * 登录功能接口
 * @author acer
 *
 */
public interface Loginable {
	/**
	 * 注册 如果用户名已经被注册，返回-1 用户名不符合返回-2 如果密码不符合返回-3 连接不到服务器 返回0
	 * 
	 * @param name
	 *            用户名 用户名只能是6-10位的英文字母
	 * @param password
	 *            密码 至少六位(6-10) 只能包含字母和数字 而且两种类型必须同时出现
	 * @return
	 */
	int registe(String name, String password);

	/**
	 * 登录 如果该用户存在 返回1登录成功 切换到登录成功页面 如果不存在 返回-1 如果密码错误返回-2 如果连接不到服务器 返回-3
	 * 
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	int login(String name, String password);
}
