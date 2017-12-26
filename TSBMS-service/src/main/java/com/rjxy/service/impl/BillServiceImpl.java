package com.rjxy.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rjxy.bean.Bill;
import com.rjxy.bean.PageBean;
import com.rjxy.dao.BillDao;
import com.rjxy.dao.impl.BillDaoImpl;
import com.rjxy.service.BillService;
import com.rjxy.utils.DataSourceUtils;

public class BillServiceImpl implements BillService {
	private BillDao billdao = new BillDaoImpl();

	@Override
	public PageBean<Bill> findMoHuBillListPage(PageBean<Bill> page, String sname, String ispay) throws SQLException {
		DataSourceUtils.startTransaction();
		int listsiex = 0;
		List<Bill> list = null;
		if (sname.equals("") && ispay.equals("")) {
			listsiex = billdao.findBillListsiex();
			list = billdao.findBillListPage(page);
			page.setList(list);
		} else if (!sname.equals("") && !ispay.equals("")) {
			listsiex = billdao.findBillListsiex2(sname, ispay);
			list = billdao.findMoHuBillListPage(page, sname, ispay);
			page.setList(list);
		} else if (!sname.equals("") && ispay.equals("")) {
			listsiex = billdao.findBillListsiex3(sname);
			list = billdao.findMoHuBillListPage1(page, sname);
		} else if (sname.equals("") && !ispay.equals("")) {
			listsiex = billdao.findBillListsiex4(ispay);
			list = billdao.findMoHuBillListPage2(page, ispay);
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

	@Override
	public PageBean<Bill> findBillListPage(PageBean<Bill> page) {
		try {
			DataSourceUtils.startTransaction();
			int listsiex = billdao.findBillListsiex();
			page.setTotalCount(listsiex);
			if (listsiex % page.getCurrentPage() == 0) {
				page.setTotalPage(listsiex / page.getCurrentPage());
			} else {
				page.setTotalPage(listsiex / page.getCurrentPage() + 1);
			}
			List<Bill> list = billdao.findBillListPage(page);
			page.setList(list);
			DataSourceUtils.commitAndRelease();
		} catch (SQLException e) {
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public boolean updateBill(Bill bill) throws SQLException {

		return billdao.updateBill(bill);
	}

	@Override
	public boolean insertBill(Bill bill) throws SQLException {

		return billdao.insertBill(bill);
	}

	@Override
	public boolean deleteBill(String b_ids) throws SQLException {

		return billdao.deleteBill(b_ids);
	}

	@Override
	public Bill getBillById(String Id) throws SQLException {
		
		return billdao.getBillById(Id);
	}

	@Override
	public boolean deleteBills(String b_ids) throws SQLException {

		return billdao.deleteBills(b_ids);
	}

}
