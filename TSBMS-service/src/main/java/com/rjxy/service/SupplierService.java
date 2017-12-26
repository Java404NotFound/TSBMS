package com.rjxy.service;

import java.sql.SQLException;
import java.util.List;

import com.rjxy.bean.PageBean;
import com.rjxy.bean.Supplier;

public interface SupplierService {
	public  PageBean<Supplier> findSupplierListPage(PageBean<Supplier> page,String sname,String decription) throws SQLException ;
	public Supplier getSupplierById(String Id) throws SQLException ;
	public List<Supplier> findSupplierNameList()throws SQLException ;
	public boolean  isSupplierName(String name) throws NumberFormatException, SQLException ;
	public boolean updateSupplier(Supplier supplier) throws SQLException ;
	public boolean insertSupplier(Supplier supplier) throws SQLException ;
	public boolean deleteSupplier(String s_ids) throws SQLException ;
}
