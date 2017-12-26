package com.rjxy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.rjxy.bean.Bill;
import com.rjxy.bean.PageBean;
import com.rjxy.dao.BillDao;
import com.rjxy.utils.DataSourceUtils;

/*
 * 分页语句
 * SELECT *
  FROM (SELECT ROWNUM AS rowno, t.*
          FROM users t
         WHERE 
    ROWNUM <=5) table_alias
 WHERE table_alias.rowno >= 3;
 * 
 * 
 */
public class BillDaoImpl implements BillDao {

	/**
	 * 分页查询数据 无模糊条件
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Bill> findBillListPage(PageBean<Bill> page) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM bill t  WHERE ROWNUM <?) table_alias WHERE table_alias.rowno >=?";
		List<Bill> list = runner.query(sql, new BeanListHandler<Bill>(Bill.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}

	/**
	 * 分页 模糊查询数据 sname 和ispay两个条件同时有
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Bill> findMoHuBillListPage(PageBean<Bill> page, String sname, String ispay) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM bill t  WHERE ROWNUM <? and  productName like  ?  and  ispay=?) table_alias WHERE table_alias.rowno >=?";
		List<Bill> list = runner.query(sql, new BeanListHandler<Bill>(Bill.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(), "%" + sname + "%",
				ispay, ((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}

	/**
	 * 分页 模糊查询数据 只有一个 sname 模糊条件
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Bill> findMoHuBillListPage1(PageBean<Bill> page, String sname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM bill t  WHERE ROWNUM <? and  productName like  ?) table_alias WHERE table_alias.rowno >=?";
		List<Bill> list = runner.query(sql, new BeanListHandler<Bill>(Bill.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(), "%" + sname + "%",
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}

	/**
	 * 分页 模糊查询数据 只有一个 ispay 模糊条件
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Bill> findMoHuBillListPage2(PageBean<Bill> page, String ispay) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM bill t  WHERE ROWNUM <? and  ispay=?) table_alias WHERE table_alias.rowno >=?";
		List<Bill> list = runner.query(sql, new BeanListHandler<Bill>(Bill.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(), ispay,
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}

	/**
	 * 修改bill
	 * 
	 */
	@Override
	public boolean updateBill(Bill bill) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		DataSourceUtils.startTransaction();
		String sql = "update bill set productname=?,amount=?,money=?,ispay=?,sname=?,description=?,unit=? where b_id=?";
		int update = runner.update(sql, bill.getProductName(), bill.getAmount(), bill.getMoney(), bill.getIsPay(),
				bill.getSname(), bill.getDescription(), bill.getUnit(), bill.getB_Id());
		DataSourceUtils.commitAndRelease();
		return update > 0 ? true : false;
	}

	/**
	 * 插入bill
	 * 
	 */
	@Override
	public boolean insertBill(Bill bill) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		DataSourceUtils.startTransaction();
		String sql = "insert into bill values(?,?,?,?,?,?,?,?,?)";
		int update = runner.update(sql, bill.getB_Id(), bill.getProductName(), bill.getAmount(), bill.getMoney(),
				bill.getIsPay(), bill.getSname(), bill.getDescription(), bill.getTradeTime(), bill.getUnit());
		DataSourceUtils.commitAndRelease();
		return update > 0 ? true : false;
	}

	/**
	 * 根据b_id删除bill
	 * 
	 */
	@Override
	public boolean deleteBill(String b_ids) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		DataSourceUtils.startTransaction();
		String sql = "delete from bill where b_id='" + b_ids + "';";
		int update = runner.update(sql);
		DataSourceUtils.commitAndRelease();
		return update > 0 ? true : false;

	}
  /**
   * 
   * 无模糊条件的总条数
   * @see com.rjxy.dao.BillDao#findBillListsiex()
   */
	@Override
	public int findBillListsiex() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from bill";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler()) + "");
		return query;
	}
	/**
	   * 
	   * sname，isPay模糊条件的总条数
	   * @see com.rjxy.dao.BillDao#findBillListsiex()
	   */
	@Override
	public int findBillListsiex2(String sname, String isPay) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from bill where productName like ? and isPay =? ";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), "%" + sname + "%", isPay) + "");
		return query;
	}
	/**
	   * 
	   * sname模糊条件的总条数
	   * @see com.rjxy.dao.BillDao#findBillListsiex()
	   */
	@Override
	public int findBillListsiex3(String sname) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from bill where productName like ? ";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), "%" + sname + "%") + "");
		return query;
	}
	/**
	   * 
	   * isPay模糊条件的总条数
	   * @see com.rjxy.dao.BillDao#findBillListsiex()
	   */
	@Override
	public int findBillListsiex4(String isPay) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from bill where isPay = ? ";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), isPay) + "");
		return query;
	}
 /**
  * 根据ID 获得 Bill
  * @see com.rjxy.dao.BillDao#getBillById(java.lang.String)
  */
	@Override
	public Bill getBillById(String Id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from bill where b_id =?";
		return runner.query(sql, new BeanHandler<Bill>(Bill.class), Id);
	}
	 /**
	  * 根据ID 删除 Bill
	  * @see com.rjxy.dao.BillDao#getBillById(java.lang.String)
	  */
	@Override
	public boolean deleteBills(String b_ids) throws SQLException {
		DataSourceUtils.startTransaction();
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from bill where b_id in (" + b_ids + ")";
		int update = runner.update(sql);
		DataSourceUtils.commitAndRelease();
		return update > 0 ? true : false;
	}

}
