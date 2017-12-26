package com.rjxy.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rjxy.bean.Bill;
import com.rjxy.bean.PageBean;
import com.rjxy.bean.Supplier;
import com.rjxy.service.BillService;
import com.rjxy.service.SupplierService;
import com.rjxy.service.impl.BillServiceImpl;
import com.rjxy.service.impl.SupplierServiceImpl;

public class BillAction extends ActionSupport {
	private Bill bill;
	private int currentCount = 0;
	private String productname = null;
	private String isPay = null;
	private String b_id;
	private List<String> detelelist;

	public List<String> getDetelelist() {
		return detelelist;
	}

	public void setDetelelist(List<String> detelelist) {
		this.detelelist = detelelist;
	}

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	private PageBean<Bill> page = new PageBean<Bill>();
	private BillService billService = new BillServiceImpl();
	private SupplierService supplierService = new SupplierServiceImpl();

	public String findBillList() {
		try {
			// 接收当前页
			if (currentCount == 0) {
				page.setCurrentCount(1);
			} else {
				page.setCurrentCount(currentCount);
			}
			// 分几行一页
			page.setCurrentPage(3);
			if (productname == null) {
				productname = "";
			}
			if (isPay == null) {
				isPay = "";
			}

			PageBean<Bill> findBillListPage = billService.findMoHuBillListPage(page, productname, isPay);

			ActionContext.getContext().put("billList", findBillListPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "yes";
	}

	public String billAdd() {
		try {
			bill.setB_Id(UUID.randomUUID().toString());
			Date date = new Date();
			java.sql.Date date2 = new java.sql.Date(date.getTime());
			bill.setTradeTime(date2);
			
			boolean insertBill = billService.insertBill(bill);
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			if (!insertBill) {
				ActionContext.getContext().put("addisPay", "no");
			}
			ActionContext.getContext().put("addisPay", "yes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "add";

	}

	public String findBillById() {
		try {
			Bill bill = billService.getBillById(b_id);
			ActionContext.getContext().put("bill", bill);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "BuId";
	}

	public void findBillSupplierNameList() {
		List<Supplier> list = null;
		String json = null;
		try {
			list = supplierService.findSupplierNameList();
			Gson gson = new Gson();
			json = gson.toJson(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String deleteBillByIds() {
		String string = "";
		if (detelelist != null) {
			for (String str : detelelist)
				string += "'" + str + "',";
		}
		String str2 = string.substring(0, string.length() - 1);
		try {
			billService.deleteBills(str2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hehe";
	}

	public String deleteBillById() {

		boolean deleteBill = false;
		try {
			deleteBill = billService.deleteBill(bill.getB_Id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (deleteBill) {
			ActionContext.getContext().put("isPay", "yes");
		} else {
			ActionContext.getContext().put("isPay", "no");
		}
		return "hehe";

	}

	public String updatebill() {
		boolean updateBill = false;
		try {
			Date date = new Date();
			java.sql.Date date2 = new java.sql.Date(date.getTime());
			bill.setTradeTime(date2);
			updateBill = billService.updateBill(bill);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (updateBill) {
			ActionContext.getContext().put("isPay", "yes");
		} else {
			ActionContext.getContext().put("isPay", "no");
		}
		return "hehe";

	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getIsPay() {
		return isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	public PageBean<Bill> getPage() {
		return page;
	}

	public void setPage(PageBean<Bill> page) {
		this.page = page;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}
}
