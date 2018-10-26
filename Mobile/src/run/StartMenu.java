package run;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.MobileDao;
import dao.impl.MobileDaoImpl;
import entity.Mobile;

/**
 * 类说明： 手机管理系统
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version 创建时间：2016年8月21日 下午1:39:24
 */
public class StartMenu {

	// 开启控制台输入
	static Scanner sc = new Scanner(System.in);

	static MobileDao mobile = new MobileDaoImpl();

	/**
	 * 程序入口
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws SQLException, InterruptedException {

		// 定义选择
		int choice = 0;

		// 提示
		System.err.println("请输入数字:");

		// 循环
		do {
			// 调用开始菜单方法
			start();
			try {
				// 接收控制台输入信息
				choice = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("请输入整数!");
			}
			// 分支判断
			switch (choice) {

			case 1:
				
				// 插入数据
				inputMob();
				break;
			case 2:
				
				// 根据品牌查询数据
				queryByBrand();
				break;
			case 3:
				
				// 查询所有数据
				queryAll();
				break;
			case 4:
				
				// 修改价格
				updatePrice();
				break;
			case 5:
				
				// 删除数据
				deleteMob();
				break;
			case 6:

				// 退出程序
				System.err.println("Stop this Mobile Application !");

				// 退出
				return;

			default:
				System.err.println("请输入1-6之内的数字!");
			}
			// 休眠1秒
			Thread.sleep(1000);
			System.err.println("按任意键继续:");
			sc.nextLine();
		} while (choice != 6);

	}

	/**
	 * 修改价格
	 */
	private static void updatePrice() {

		// 提示
		System.out.println("请输入手机编号:");

		// 接收序号
		int id = sc.nextInt();

		// 提示
		System.out.println("请输入要修改的价格:");

		// 接收价格
		double price = sc.nextDouble();

		// 执行修改
		mobile.updatePrice(id, price);
	}

	/**
	 * 根据品牌查询数据
	 */
	private static void queryByBrand() {

		// 提示
		System.out.println("请输入手机品牌:");
		String brand = null;
		try {

			// 得到控制台输入的数据
			brand = sc.nextLine();
			// 得到手机类对象
			List<Mobile> list = mobile.findByBrand(brand);

			// 查询所有数据
			System.err.println("手机序号\t\t手机品牌\t\t手机型号\t\t手机价格\t\t手机数量\t\t手机型号");

			// 遍历
			for (Mobile mobile : list) {
				// 打印
				System.out.println(mobile);
			}

		} catch (SQLException e) {
			System.out.println("请检查输入的数据!!!");
		}

	}

	/**
	 * 查询所有记录
	 * 
	 * @throws SQLException
	 */
	private static void queryAll() throws SQLException {

		// 执行查询所有方法
		List<Mobile> list = mobile.findAll();

		// 查询所有数据
		System.out.println("手机序号\t\t手机品牌\t\t手机型号\t\t手机价格\t\t手机数量\t\t手机型号");

		// 遍历
		for (Mobile mobile : list) {
			// 打印
			System.out.println(mobile);
		}
	}

	/**
	 * 根据编号删除手机记录
	 */
	private static void deleteMob() {

		// 提示删除
		System.out.println("请输入要删除的编号：");

		try {

			// 接收控制台读入的数据
			int id = sc.nextInt();

			// 调用删除方法
			mobile.delMob(id);

		} catch (Exception e) {

			System.out.println("请输入数字!");

		}
	}

	/**
	 * 插入记录
	 */
	private static void inputMob() {

		try {

			// 提示
			System.out.println("请输入手机编号:");

			// 接收输入数据
			int id = sc.nextInt();

			// 读取完毕
			sc.nextLine();

			// 提示
			System.out.println("请输入手机品牌:");

			// 接收输入数据
			String brand = sc.nextLine();

			// 提示
			System.out.println("请输入手机型号:");

			// 接收输入数据
			String model = sc.nextLine();

			// 提示
			System.out.println("请输入手机价格:");

			// 接收输入数据
			double price = sc.nextDouble();

			// 提示
			System.out.println("请输入手机数量:");

			// 接收输入数据
			int count = sc.nextInt();

			// 读取完毕
			sc.nextLine();

			// 提示
			System.out.println("请输入手机版本:");

			// 接收输入数据
			String version = sc.nextLine();

			// 实例化
			Mobile mob = new Mobile(id, brand, model, price, count, version);

			// 添加
			mobile.addMoblie(mob);

		} catch (Exception e) {
			System.out.println("请检查输入的格式是否正确!!!");
		}
	}

	/**
	 * 开始菜单
	 */
	private static void start() {
		System.err.println("----------------------------------------------------------------------------");
		System.err.println("\t\t手机信息管理系统");
		System.err.println("\t\t1.手机录入");
		System.err.println("\t\t2.根据手机品牌查询手机信息");
		System.err.println("\t\t3.查询所有手机");
		System.err.println("\t\t4.根据手机编号修改手机价格");
		System.err.println("\t\t5.根据手机编号删除手机记录");
		System.err.println("\t\t6.退出");
		System.err.println("----------------------------------------------------------------------------");
	}

}
