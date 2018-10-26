package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Mobile;

/**
 * 类说明： 手机接口
 *
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version 创建时间：2016年8月21日 下午1:37:49
 */
public interface MobileDao {

	// 查询所有手机记录
	public List<Mobile> findAll() throws SQLException;

	// 按品牌查询所有手机记录
	public List<Mobile> findByBrand(String brand) throws SQLException;

	// 添加手机
	public void addMoblie(Mobile mob);

	// 删除手机记录
	public void delMob(int id);

	// 根据序号修改手机价格
	public void updatePrice(int id,double price);
}
