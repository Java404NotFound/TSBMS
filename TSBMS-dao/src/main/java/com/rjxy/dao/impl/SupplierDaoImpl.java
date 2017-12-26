package com.rjxy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.rjxy.bean.PageBean;
import com.rjxy.bean.Supplier;
import com.rjxy.dao.SupplierDao;
import com.rjxy.utils.DataSourceUtils;

public class SupplierDaoImpl implements SupplierDao {
	/*
	 * 分页语句 SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM users t WHERE ROWNUM
	 * <=5) table_alias WHERE table_alias.rowno >= 3;
	 * 
	 * 
	 */
	/**
	 * 分页查询数据
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Supplier> findSupplierListPage(PageBean<Supplier> page) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM Supplier t  WHERE ROWNUM <?) table_alias WHERE table_alias.rowno >=?";
		List<Supplier> list = runner.query(sql, new BeanListHandler<Supplier>(Supplier.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;

	}
	/**
	 * 修改supplier
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */

	@Override
	public boolean updateSupplier(Supplier supplier) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update supplier set s_id=?, sname=?,decription=?,contacter=?,fax=?,phone=?,address=? where s_id=?";
		int update = runner.update(sql, supplier.getS_id(), supplier.getSname(), supplier.getDecription(),
				supplier.getContacter(), supplier.getFax(), supplier.getPhone(), supplier.getAddress(),
				supplier.getS_id());
		return update > 0 ? true : false;
	}
	
	/**
	 * 插入supplier
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public boolean insertSupplier(Supplier supplier) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		DataSourceUtils.startTransaction();
		String sql = "insert into supplier values(?,?,?,?,?,?,?)";
		int update = runner.update(sql, supplier.getS_id(), supplier.getSname(), supplier.getDecription(),
				supplier.getContacter(), supplier.getFax(), supplier.getPhone(), supplier.getAddress());
		DataSourceUtils.commitAndRelease();
		return update > 0 ? true : false;
	}
	/**
	 * 批量删除supplier
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public boolean deleteSupplier(String s_ids) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		DataSourceUtils.startTransaction();
		String sql = "delete from supplier where s_id='" + s_ids + "'";
		int update = runner.update(sql);
		DataSourceUtils.commitAndRelease();
		return update > 0 ? true : false;
	}
	/**
	 *sname，decription 两个条件的模糊查询
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Supplier> findMoHuSupplierListPage1(PageBean<Supplier> page, String sname, String decription)
			throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM Supplier t  WHERE ROWNUM <?  and sname like ?  and decription like ?  ) table_alias WHERE table_alias.rowno >=?";
		List<Supplier> list = runner.query(sql, new BeanListHandler<Supplier>(Supplier.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(), "%" + sname + "%",
				"%" + decription + "%", ((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}
	/**
	 * sname一个条件的模糊查询
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Supplier> findMoHuSupplierListPage2(PageBean<Supplier> page, String sname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM Supplier t  WHERE ROWNUM <?  and sname like ?   ) table_alias WHERE table_alias.rowno >=?";
		List<Supplier> list = runner.query(sql, new BeanListHandler<Supplier>(Supplier.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(), "%" + sname + "%",
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}
	/**
	 * decription一个条件的模糊查询
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Supplier> findMoHuSupplierListPage3(PageBean<Supplier> page, String decription) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM Supplier t  WHERE ROWNUM <?  and decription like ?  ) table_alias WHERE table_alias.rowno >=?";
		List<Supplier> list = runner.query(sql, new BeanListHandler<Supplier>(Supplier.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(),
				"%" + decription + "%", ((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}
	/**
	 * 无条件的总页数
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public int findSupplierListsiex() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from supplier";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler()) + "");
		return query;

	}
	/**
	 * sname，decription条件的总页数
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public int findSupplierListsiex2(String sname, String decription) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from supplier where sname like ? and decription like ? ";
		int query = Integer
				.parseInt(runner.query(sql, new ScalarHandler(), "%" + sname + "%", "%" + decription + "%") + "");
		return query;
	}
	/**
	 * sname条件的总页数
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public int findSupplierListsiex3(String sname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from supplier where sname like ?";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), "%" + sname + "%") + "");
		return query;
	}
	/**
	 * decription条件的总页数
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public int findSupplierListsiex4(String decription) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from supplier where decription like ?";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), "%" + decription + "%") + "");
		return query;
	}
	/**
	 * 查询所有的supplier的sname
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Supplier> findSupplierNameList() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select sname from supplier  ";
		return runner.query(sql, new BeanListHandler<Supplier>(Supplier.class));

	}
	/**
	 * 根据Id获得Supplier
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public Supplier getSupplierById(String Id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from supplier where S_ID =? ";
		return runner.query(sql, new BeanHandler<Supplier>(Supplier.class), Id);

	}
	/**
	 * 根据sname获得Supplier
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public boolean isSupplierName(String name) throws NumberFormatException, SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(1) from supplier where sname =? ";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(),name) + "");
		return query > 0 ? false : true;
	}

}
