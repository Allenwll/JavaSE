package login;

/**
 * �����
 * 
 * @author acer
 *
 */
public class TestMain {

	public static void main(String[] args) {
		// ʵ������¼��
		MyLogin mylogin = new MyLogin();
		// ����ע�᷽��
		myLogin(mylogin, "sxtAllen", "Allen124");
		// ���õ�¼����
		login(mylogin, "sxtAllen", "Allen124");

	}

	/**
	 * ��̬ ע�᷽��
	 * 
	 * @param login
	 *            ʵ������ �β� �ӿ�
	 * @param name
	 *            �û���
	 * @param pwd
	 *            ����
	 */
	static void myLogin(Loginable login, String name, String pwd) {
		// �õ��������ע�᷽�����ص�ֵ
		int result = login.registe(name, pwd);
		switch (result) {
		case -1:
			System.out.println("�û����ѱ�ע�ᣡ");
			break;
		case -2:
			System.out.println("�û�����Ч!");
			break;
		case -3:
			System.out.println("������Ч!");
			break;
		case 1:
			System.out.println("ע��ɹ���");
			break;
		}
	}

	/**
	 * ��̬ ��¼����
	 * 
	 * @param login
	 *            ʵ������ �β� �ӿ�
	 * @param name
	 *            �û���
	 * @param pwd
	 *            ����
	 */
	static void login(Loginable login, String name, String password) {
		int result = login.login(name, password);
		switch (result) {
		case -1:
			System.out.println("�û�������");
			break;
		case -2:
			System.out.println("�������");
			break;
		case 1:
			System.out.println("��¼�ɹ���");
			break;
		}
	}

}
