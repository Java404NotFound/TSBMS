package com.rjxy.dao;

import java.sql.SQLException;
import java.util.List;

import com.rjxy.bean.PageBean;
import com.rjxy.bean.Supplier;

public interface SupplierDao {

	public Supplier getSupplierById(String Id) throws SQLException ;
	
	public boolean  isSupplierName(String name) throws NumberFormatException, SQLException ;

	public List<Supplier> findSupplierListPage(PageBean<Supplier> page) throws SQLException;

	public List<Supplier> findMoHuSupplierListPage1(PageBean<Supplier> page, String sname, String decription)
			throws SQLException;

	public List<Supplier> findMoHuSupplierListPage2(PageBean<Supplier> page, String sname) throws SQLException;

	public List<Supplier> findMoHuSupplierListPage3(PageBean<Supplier> page, String decription) throws SQLException;

	public int findSupplierListsiex() throws SQLException;

	public int findSupplierListsiex2(String sname, String decription) throws SQLException;

	public int findSupplierListsiex3(String sname) throws SQLException;

	public int findSupplierListsiex4(String decription) throws SQLException;

	public List<Supplier> findSupplierNameList() throws SQLException;

	public boolean updateSupplier(Supplier bill) throws SQLException;

	public boolean insertSupplier(Supplier bill) throws SQLException;

	public boolean deleteSupplier(String b_ids) throws SQLException;

}
