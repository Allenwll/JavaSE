package run;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.MobileDao;
import dao.impl.MobileDaoImpl;
import entity.Mobile;

/**
 * ��˵���� �ֻ�����ϵͳ
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version ����ʱ�䣺2016��8��21�� ����1:39:24
 */
public class StartMenu {

	// ��������̨����
	static Scanner sc = new Scanner(System.in);

	static MobileDao mobile = new MobileDaoImpl();

	/**
	 * �������
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws SQLException, InterruptedException {

		// ����ѡ��
		int choice = 0;

		// ��ʾ
		System.err.println("����������:");

		// ѭ��
		do {
			// ���ÿ�ʼ�˵�����
			start();
			try {
				// ���տ���̨������Ϣ
				choice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("����������!");
			}
			// ��֧�ж�
			switch (choice) {

			case 1:
				
				// ��������
				inputMob();
				break;
			case 2:
				
				// ����Ʒ�Ʋ�ѯ����
				queryByBrand();
				break;
			case 3:
				
				// ��ѯ��������
				queryAll();
				break;
			case 4:
				
				// �޸ļ۸�
				updatePrice();
				break;
			case 5:
				
				// ɾ������
				deleteMob();
				break;
			case 6:

				// �˳�����
				System.err.println("Stop this Mobile Application !");

				// �˳�
				return;

			default:
				System.err.println("������1-6֮�ڵ�����!");
			}
			// ����1��
			Thread.sleep(1000);
			System.err.println("�����������:");
			sc.nextLine();
		} while (choice != 6);

	}

	/**
	 * �޸ļ۸�
	 */
	private static void updatePrice() {

		// ��ʾ
		System.out.println("�������ֻ����:");

		// �������
		int id = sc.nextInt();

		// ��ʾ
		System.out.println("������Ҫ�޸ĵļ۸�:");

		// ���ռ۸�
		double price = sc.nextDouble();

		// ִ���޸�
		mobile.updatePrice(id, price);
	}

	/**
	 * ����Ʒ�Ʋ�ѯ����
	 */
	private static void queryByBrand() {

		// ��ʾ
		System.out.println("�������ֻ�Ʒ��:");
		String brand = null;
		try {

			// �õ�����̨���������
			brand = sc.nextLine();
			// �õ��ֻ������
			List<Mobile> list = mobile.findByBrand(brand);

			// ��ѯ��������
			System.err.println("�ֻ����\t\t�ֻ�Ʒ��\t\t�ֻ��ͺ�\t\t�ֻ��۸�\t\t�ֻ�����\t\t�ֻ��ͺ�");

			// ����
			for (Mobile mobile : list) {
				// ��ӡ
				System.out.println(mobile);
			}

		} catch (SQLException e) {
			System.out.println("�������������!!!");
		}

	}

	/**
	 * ��ѯ���м�¼
	 * 
	 * @throws SQLException
	 */
	private static void queryAll() throws SQLException {

		// ִ�в�ѯ���з���
		List<Mobile> list = mobile.findAll();

		// ��ѯ��������
		System.out.println("�ֻ����\t\t�ֻ�Ʒ��\t\t�ֻ��ͺ�\t\t�ֻ��۸�\t\t�ֻ�����\t\t�ֻ��ͺ�");

		// ����
		for (Mobile mobile : list) {
			// ��ӡ
			System.out.println(mobile);
		}
	}

	/**
	 * ���ݱ��ɾ���ֻ���¼
	 */
	private static void deleteMob() {

		// ��ʾɾ��
		System.out.println("������Ҫɾ���ı�ţ�");

		try {

			// ���տ���̨���������
			int id = sc.nextInt();

			// ����ɾ������
			mobile.delMob(id);

		} catch (Exception e) {

			System.out.println("����������!");

		}
	}

	/**
	 * �����¼
	 */
	private static void inputMob() {

		try {

			// ��ʾ
			System.out.println("�������ֻ����:");

			// ������������
			int id = sc.nextInt();

			// ��ȡ���
			sc.nextLine();

			// ��ʾ
			System.out.println("�������ֻ�Ʒ��:");

			// ������������
			String brand = sc.nextLine();

			// ��ʾ
			System.out.println("�������ֻ��ͺ�:");

			// ������������
			String model = sc.nextLine();

			// ��ʾ
			System.out.println("�������ֻ��۸�:");

			// ������������
			double price = sc.nextDouble();

			// ��ʾ
			System.out.println("�������ֻ�����:");

			// ������������
			int count = sc.nextInt();

			// ��ȡ���
			sc.nextLine();

			// ��ʾ
			System.out.println("�������ֻ��汾:");

			// ������������
			String version = sc.nextLine();

			// ʵ����
			Mobile mob = new Mobile(id, brand, model, price, count, version);

			// ���
			mobile.addMoblie(mob);

		} catch (Exception e) {
			System.out.println("��������ĸ�ʽ�Ƿ���ȷ!!!");
		}
	}

	/**
	 * ��ʼ�˵�
	 */
	private static void start() {
		System.err.println("----------------------------------------------------------------------------");
		System.err.println("\t\t�ֻ���Ϣ����ϵͳ");
		System.err.println("\t\t1.�ֻ�¼��");
		System.err.println("\t\t2.�����ֻ�Ʒ�Ʋ�ѯ�ֻ���Ϣ");
		System.err.println("\t\t3.��ѯ�����ֻ�");
		System.err.println("\t\t4.�����ֻ�����޸��ֻ��۸�");
		System.err.println("\t\t5.�����ֻ����ɾ���ֻ���¼");
		System.err.println("\t\t6.�˳�");
		System.err.println("----------------------------------------------------------------------------");
	}

}
