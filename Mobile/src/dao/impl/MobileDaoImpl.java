/**
 *
 *  @author Allen Wang  
 * 
 * @Email   1303542271@qq.com
 *
 * @version ����ʱ�䣺2016��8��21�� ����1:38:14 
 * 
 * ��˵���� 
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
 * ��˵����
 * 
 * Dao�ӿڵ�ʵ����
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version ����ʱ�䣺2016��8��21�� ����1:38:14
 */
public class MobileDaoImpl implements MobileDao {

	@Override
	public List<Mobile> findAll() throws SQLException {

		// ��ʼ��
		List<Mobile> list = new ArrayList<Mobile>();

		// SQL���
		String sql = "select * from mobile";

		// ����
		Connection conn = BaseDao.getConn();

		// ����ִ����
		PreparedStatement psmt = conn.prepareStatement(sql);

		// �����
		ResultSet rs = psmt.executeQuery();

		// ����
		Mobile mobile = null;
		// ѭ����ȡ
		while (rs.next()) {

			// �õ�id
			int id = rs.getInt(1);

			// �õ�Ʒ��
			String brand = rs.getString(2);

			// �õ��ͺ�
			String model = rs.getString(3);

			// �õ��۸�
			double price = rs.getDouble(4);

			// �õ�����
			int count = rs.getInt(5);

			// �õ��汾
			String version = rs.getString(6);

			// ʵ����
			mobile = new Mobile(id, brand, model, price, count, version);

			// ���뼯��
			list.add(mobile);
		}
		// �ر�����
		BaseDao.closeAll(rs, psmt, conn);

		return list;
	}

	@Override
	public List<Mobile> findByBrand(String brand) throws SQLException {

		// ��ʼ��
		List<Mobile> list = new ArrayList<Mobile>();

		// SQL���
		String sql = "select * from mobile where Brand=?";

		// ����
		Connection conn = BaseDao.getConn();

		// ����ִ����
		PreparedStatement psmt = conn.prepareStatement(sql);

		// ����
		psmt.setString(1, brand);
		// �����
		ResultSet rs = psmt.executeQuery();

		// id
		int id = 0;

		// �ͺ�
		String model = null;

		// �۸�
		double price = 0.0;

		// ����
		int count = 0;

		// �汾
		String version = null;

		// ����
		Mobile mobile = null;

		// ѭ����ȡ
		while (rs.next()) {

			// �õ�id
			id = rs.getInt(1);

			// �õ��ͺ�
			model = rs.getString(3);

			// �õ��۸�
			price = rs.getDouble(4);

			// �õ�����
			count = rs.getInt(5);

			// �õ��汾
			version = rs.getString(6);

			// ʵ����
			mobile = new Mobile(id, brand, model, price, count, version);

			// ���뼯��
			list.add(mobile);

		}

		// �ر�����
		BaseDao.closeAll(rs, psmt, conn);

		return list;
	}

	@Override
	public void addMoblie(Mobile mob) {

		// SQL���
		String sql = "insert into mobile values(?,?,?,?,?,?)";

		// �ɱ����
		Object[] obj = { mob.getId(), mob.getBrand(), mob.getModel(), mob.getPrice(), mob.getCount(),
				mob.getVersion() };

		// ִ�в������
		int result = BaseDao.execUpdate(sql, obj);

		if (result > 0)
			System.out.println("����ɹ�!");
		else
			System.out.println("����ʧ��!");
	}

	@Override
	public void delMob(int id) {

		// SQL���
		String sql = "delete mobile where id=?";

		// �ɱ����
		Object[] obj = { id };

		// ִ��ɾ������
		int result = BaseDao.execUpdate(sql, obj);

		if (result > 0)
			System.out.println("ɾ���ɹ�!");
		else
			System.out.println("û���ҵ��ñ��!");

	}

	@Override
	public void updatePrice(int id, double price) {

		// SQL���
		String sql = "update mobile set price=? where id=?";

		// �ɱ����
		Object[] obj = { price, id };

		// �����޸�
		int result = BaseDao.execUpdate(sql, obj);

		if (result > 0)
			System.out.println("�޸ĳɹ�!!!");
		else
			System.out.println("�޸�ʧ��!!!");
	}

}
