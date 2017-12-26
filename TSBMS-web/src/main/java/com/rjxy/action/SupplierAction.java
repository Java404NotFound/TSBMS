package com.rjxy.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rjxy.bean.PageBean;
import com.rjxy.bean.Supplier;
import com.rjxy.service.SupplierService;
import com.rjxy.service.impl.SupplierServiceImpl;

public class SupplierAction extends ActionSupport {
	private int currentCount = 0;
	private PageBean<Supplier> page = new PageBean<Supplier>();
	private SupplierService supplierService = new SupplierServiceImpl();
	private String providerName;
	private String decription;
	private Supplier supplier;
	private String sname;
	private String s_id;

	// 验证供应商名称是否重复 方法
	public void isSupplierName() {
		try {
			boolean supplierName = supplierService.isSupplierName(sname);

			String json = "{\"isExist\":" + supplierName + "}";

			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			try {
				ServletActionContext.getResponse().getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 根据ID 查找 Supplier
	public String findSupplierById() {
		try {
			Supplier supplier = supplierService.getSupplierById(s_id);
			ActionContext.getContext().put("Supplier", supplier);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "suId";

	}

	// 更新 Supplier
	public String updateSupplier() {
		try {
			supplierService.updateSupplier(supplier);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "hehe";

	}

	// 删除 Supplier
	public String deleteSupplier() {
		try {
			supplierService.deleteSupplier(supplier.getS_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "hehe";

	}

	// 添加 Supplier
	public String addSupplier() {
		boolean insertSupplier = false;
		try {
			String string = UUID.randomUUID().toString();
			supplier.setS_id(string);
			insertSupplier = supplierService.insertSupplier(supplier);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!insertSupplier) {
		ActionContext.getContext().put("isPay", "no");
		}
		ActionContext.getContext().put("isPay", "yes");

		return "add";
	}

	// 分页显示 Supplier 数据
	public String findSupplierList() {
		try {
			// 接收当前页
			if (currentCount == 0) {
				page.setCurrentCount(1);
			} else {
				page.setCurrentCount(currentCount);
			}
			// 分几行一页
			page.setCurrentPage(3);
			if (providerName == null) {
				providerName = "";
			}
			if (decription == null) {
				decription = "";
			}
			PageBean<Supplier> findSupplierList = supplierService.findSupplierListPage(page, providerName, decription);
			ActionContext.getContext().put("SupplierList", findSupplierList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "yes";

	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public PageBean<Supplier> getPage() {
		return page;
	}

	public void setPage(PageBean<Supplier> page) {
		this.page = page;
	}

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}
