/**
 *
 *  @author Allen Wang  
 * 
 * @Email   1303542271@qq.com
 *
 * @version 创建时间：2016年8月21日 下午1:38:14 
 * 
 * 类说明： 
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MobileDao;
import entity.Mobile;
import util.BaseDao;

/**
 * 类说明：
 * 
 * Dao接口的实现类
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version 创建时间：2016年8月21日 下午1:38:14
 */
public class MobileDaoImpl implements MobileDao {

	@Override
	public List<Mobile> findAll() throws SQLException {

		// 初始化
		List<Mobile> list = new ArrayList<Mobile>();

		// SQL语句
		String sql = "select * from mobile";

		// 连接
		Connection conn = BaseDao.getConn();

		// 命令执行器
		PreparedStatement psmt = conn.prepareStatement(sql);

		// 结果集
		ResultSet rs = psmt.executeQuery();

		// 声明
		Mobile mobile = null;
		// 循环读取
		while (rs.next()) {

			// 得到id
			int id = rs.getInt(1);

			// 得到品牌
			String brand = rs.getString(2);

			// 得到型号
			String model = rs.getString(3);

			// 得到价格
			double price = rs.getDouble(4);

			// 得到数量
			int count = rs.getInt(5);

			// 得到版本
			String version = rs.getString(6);

			// 实例化
			mobile = new Mobile(id, brand, model, price, count, version);

			// 存入集合
			list.add(mobile);
		}
		// 关闭连接
		BaseDao.closeAll(rs, psmt, conn);

		return list;
	}

	@Override
	public List<Mobile> findByBrand(String brand) throws SQLException {

		// 初始化
		List<Mobile> list = new ArrayList<Mobile>();

		// SQL语句
		String sql = "select * from mobile where Brand=?";

		// 连接
		Connection conn = BaseDao.getConn();

		// 命令执行器
		PreparedStatement psmt = conn.prepareStatement(sql);

		// 设置
		psmt.setString(1, brand);
		// 结果集
		ResultSet rs = psmt.executeQuery();

		// id
		int id = 0;

		// 型号
		String model = null;

		// 价格
		double price = 0.0;

		// 数量
		int count = 0;

		// 版本
		String version = null;

		// 声明
		Mobile mobile = null;

		// 循环读取
		while (rs.next()) {

			// 得到id
			id = rs.getInt(1);

			// 得到型号
			model = rs.getString(3);

			// 得到价格
			price = rs.getDouble(4);

			// 得到数量
			count = rs.getInt(5);

			// 得到版本
			version = rs.getString(6);

			// 实例化
			mobile = new Mobile(id, brand, model, price, count, version);

			// 存入集合
			list.add(mobile);

		}

		// 关闭连接
		BaseDao.closeAll(rs, psmt, conn);

		return list;
	}

	@Override
	public void addMoblie(Mobile mob) {

		// SQL语句
		String sql = "insert into mobile values(?,?,?,?,?,?)";

		// 可变参数
		Object[] obj = { mob.getId(), mob.getBrand(), mob.getModel(), mob.getPrice(), mob.getCount(),
				mob.getVersion() };

		// 执行插入操作
		int result = BaseDao.execUpdate(sql, obj);

		if (result > 0)
			System.out.println("插入成功!");
		else
			System.out.println("插入失败!");
	}

	@Override
	public void delMob(int id) {

		// SQL语句
		String sql = "delete mobile where id=?";

		// 可变参数
		Object[] obj = { id };

		// 执行删除操作
		int result = BaseDao.execUpdate(sql, obj);

		if (result > 0)
			System.out.println("删除成功!");
		else
			System.out.println("没有找到该编号!");

	}

	@Override
	public void updatePrice(int id, double price) {

		// SQL语句
		String sql = "update mobile set price=? where id=?";

		// 可变参数
		Object[] obj = { price, id };

		// 调用修改
		int result = BaseDao.execUpdate(sql, obj);

		if (result > 0)
			System.out.println("修改成功!!!");
		else
			System.out.println("修改失败!!!");
	}

}
