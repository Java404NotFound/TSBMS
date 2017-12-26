package com.rjxy.service.impl;

import java.sql.SQLException;
import java.util.List;


import com.rjxy.bean.PageBean;
import com.rjxy.bean.Supplier;
import com.rjxy.dao.SupplierDao;
import com.rjxy.dao.impl.SupplierDaoImpl;
import com.rjxy.service.SupplierService;
import com.rjxy.utils.DataSourceUtils;

public class SupplierServiceImpl implements SupplierService {
	private SupplierDao supplierDao = new SupplierDaoImpl();
	@Override
	public PageBean<Supplier> findSupplierListPage(PageBean<Supplier> page, String sname, String decription)
			throws SQLException {
		DataSourceUtils.startTransaction();
		int listsiex = 0;
		List<Supplier> list = null;
		if (sname.equals("") && decription.equals("")) {
			listsiex = supplierDao.findSupplierListsiex();
			list = supplierDao.findSupplierListPage(page);
			page.setList(list);
		} else if (!sname.equals("") && !decription.equals("")) {
			listsiex = supplierDao.findSupplierListsiex2(sname, decription);
			list = supplierDao.findMoHuSupplierListPage1(page, sname, decription);
			page.setList(list);
		} else if (!sname.equals("") && decription.equals("")) {
			listsiex = supplierDao.findSupplierListsiex3(sname);
			list = supplierDao.findMoHuSupplierListPage2(page, sname);
		} else if (sname.equals("") && !decription.equals("")) {
			listsiex = supplierDao.findSupplierListsiex4(decription);
			list = supplierDao.findMoHuSupplierListPage3(page, decription);
		}
		if (listsiex % page.getCurrentPage() == 0) {
			page.setTotalPage(listsiex / page.getCurrentPage());
		} else {
			page.setTotalPage(listsiex / page.getCurrentPage() + 1);
		}

		page.setTotalCount(listsiex);
		page.setList(list);
		DataSourceUtils.commitAndRelease();

		return page;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) throws SQLException {

		return supplierDao.updateSupplier(supplier);
	}

	@Override
	public boolean insertSupplier(Supplier supplier) throws SQLException {

		return supplierDao.insertSupplier(supplier);
	}
	
	@Override
	public boolean deleteSupplier(String s_ids) throws SQLException {
		return supplierDao.deleteSupplier(s_ids);
	}

	@Override
	public List<Supplier> findSupplierNameList() throws SQLException {
		// TODO Auto-generated method stub
		return supplierDao.findSupplierNameList();
	}

	@Override
	public boolean isSupplierName(String name) throws NumberFormatException, SQLException {
	
		return	supplierDao.isSupplierName(name);
	}

	@Override
	public Supplier getSupplierById(String Id) throws SQLException {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierById(Id);
	}

}
