package login;
/**
 * ��¼���ܽӿ�
 * @author acer
 *
 */
public interface Loginable {
	/**
	 * ע�� ����û����Ѿ���ע�ᣬ����-1 �û��������Ϸ���-2 ������벻���Ϸ���-3 ���Ӳ��������� ����0
	 * 
	 * @param name
	 *            �û��� �û���ֻ����6-10λ��Ӣ����ĸ
	 * @param password
	 *            ���� ������λ(6-10) ֻ�ܰ�����ĸ������ �����������ͱ���ͬʱ����
	 * @return
	 */
	int registe(String name, String password);

	/**
	 * ��¼ ������û����� ����1��¼�ɹ� �л�����¼�ɹ�ҳ�� ��������� ����-1 ���������󷵻�-2 ������Ӳ��������� ����-3
	 * 
	 * @param name
	 *            �û���
	 * @param password
	 *            ����
	 * @return
	 */
	int login(String name, String password);
}
