package com.rjxy.service;

import java.sql.SQLException;


import com.rjxy.bean.Bill;
import com.rjxy.bean.PageBean;

public interface BillService {
	public PageBean<Bill> findBillListPage(PageBean<Bill> page) throws SQLException ;
	public PageBean<Bill> findMoHuBillListPage(PageBean<Bill> page,String sname,String ispay) throws SQLException ;
	public boolean updateBill(Bill bill) throws SQLException ;
	public boolean insertBill(Bill bill) throws SQLException ;
	public boolean deleteBill(String b_ids) throws SQLException ;
	public Bill getBillById(String Id)throws SQLException ;
	public boolean deleteBills(String b_ids)throws SQLException ;
}
