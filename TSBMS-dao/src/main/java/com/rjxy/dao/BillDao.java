package com.rjxy.dao;

import java.sql.SQLException;
import java.util.List;

import com.rjxy.bean.Bill;
import com.rjxy.bean.PageBean;

public interface BillDao {
	
	
	public Bill getBillById(String Id)throws SQLException ;
	public boolean deleteBills(String b_ids) throws SQLException ;
	public List<Bill> findBillListPage(PageBean<Bill> page) throws SQLException ;
	public List<Bill> findMoHuBillListPage(PageBean<Bill> page,String sname,String ispay) throws SQLException ;
	public List<Bill> findMoHuBillListPage1(PageBean<Bill> page,String sname) throws SQLException ;
	public List<Bill> findMoHuBillListPage2(PageBean<Bill> page,String ispay) throws SQLException ;
	public int findBillListsiex() throws SQLException;
	public int findBillListsiex2(String sname,String isPay) throws SQLException;
	public int findBillListsiex3(String sname) throws SQLException;
	public int findBillListsiex4(String isPay) throws SQLException;
	public boolean updateBill(Bill bill) throws SQLException ;
	public boolean insertBill(Bill bill) throws SQLException ;
	public boolean deleteBill(String b_ids) throws SQLException ;
}
