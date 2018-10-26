package login;

/**
 * ��¼�� ʵ�ֵ�¼�ӿ�
 * 
 * @author acer
 *
 */
public class MyLogin implements Loginable {
	// ��д�ӿ�ע�᷽��
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
	 * �ж����ݿ����Ƿ��и��û���
	 * 
	 * @param name
	 * @return
	 */
	private boolean hasUser(String name) {
		//�����ݿ⸳������������ users
		Users[] users = DataBase.USERS;
		//ѭ���ж��������û����Ƿ�����������β�
		for (int i = 0; i < users.length; i++) {
			if (users[i].getName().equals(name))
				return true;
		}
		return false;
	}

	/**
	 * �ж��û�������Ч��
	 */
	private boolean isNameVaild(String name) {
		//�õ��βεĳ���
		int len = name.length();
		//�ų�������С��6���ߴ���10�����
		if (len < 6 || len > 10)
			return false;
		//ѭ���ж��û������Ƿ��в�����ĸ�����
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c < 'z'))
				return true;
		}
		return false;
	}

	/**
	 * �ж��������Ч��
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
	 * �ж��ַ���ӵ�м�����ĸ
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
	 * �ж��ַ���ӵ�м�������
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
	 * ��¼
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
	 * ����
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
