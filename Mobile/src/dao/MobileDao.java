package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Mobile;

/**
 * ��˵���� �ֻ��ӿ�
 *
 *
 * @author Allen Wang @Email 1303542271@qq.com
 *
 * @version ����ʱ�䣺2016��8��21�� ����1:37:49
 */
public interface MobileDao {

	// ��ѯ�����ֻ���¼
	public List<Mobile> findAll() throws SQLException;

	// ��Ʒ�Ʋ�ѯ�����ֻ���¼
	public List<Mobile> findByBrand(String brand) throws SQLException;

	// ����ֻ�
	public void addMoblie(Mobile mob);

	// ɾ���ֻ���¼
	public void delMob(int id);

	// ��������޸��ֻ��۸�
	public void updatePrice(int id,double price);
}
