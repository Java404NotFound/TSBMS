package com.rjxy.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rjxy.bean.PageBean;
import com.rjxy.bean.Users;
import com.rjxy.service.UserService;
import com.rjxy.service.impl.UserServiceImpl;
import com.rjxy.utils.MD5Utils;

public class UserAction extends ActionSupport {
	private Users users;
	private UserService userService = new UserServiceImpl();
	private int currentCount = 0;
	private PageBean<Users> page = new PageBean<Users>();
	private String userName;

	public String findUserById() {
		Users users2 = null;
		try {
			users2 = userService.getUsersById(users.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionContext.getContext().put("user", users2);
		return "UserbyId";

	}

	public void findUserPasswordById() {
		Users users2 = null;
		String json = null;
		try {
			users2 = userService.getUsersById(users.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String md5 = MD5Utils.md5(users.getPassword());
		if (md5.equals(users2.getPassword())) {
			json = "{\"isExist\":" + true + "}";
		} else {
			json = "{\"isExist\":" + false + "}";
		}
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String findUsersList() {
		try {
			// 接收当前页
			if (currentCount == 0) {
				page.setCurrentCount(1);
			} else {
				page.setCurrentCount(currentCount);
			}
		
			if (userName == null) {
				userName = "";
			}
			// 分几行一页
			page.setCurrentPage(3);
			PageBean<Users> findUsersList = userService.findUsersListPage(page, userName);
			ActionContext.getContext().put("userName", userName);
			ActionContext.getContext().put("UsersList", findUsersList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "hehe";

	}

	// 用户登录Action
	public String login() {
		try {
			users.setPassword(MD5Utils.md5(users.getPassword()));
			Users users2 = userService.logic(users);
			if (users2 != null) {
				if (!users2.getUsername().equals("") || !users2.getPassword().equals("")) {
					Map<String, Object> session = ActionContext.getContext().getSession();
					session.put("Users", users2);
					return "yes";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ActionContext.getContext().put("no", "用户名或者密码错误");
		return "no";
	}

	// 添加用户Action
	public String addUser() {
		boolean flage = false;
		try {
			users.setU_id(UUID.randomUUID().toString());
			users.setPassword(MD5Utils.md5(users.getPassword()));
			flage = userService.insertUsers(users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (flage) {
			ActionContext.getContext().put("isPay", "yes");

		} else {
			ActionContext.getContext().put("isPay", "no");
		}
		return "add";

	}

	public void isUserName() {
		try {
			boolean supplierName = userService.isUserName(userName);

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

	public String updateUserPassWord() {
		boolean passWord = false;
		try {
			users.setPassword(MD5Utils.md5(users.getPassword()));
			passWord = userService.updatePassWord(users.getPassword(), users.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (passWord) {
			ActionContext.getContext().put("isPay", "yes");
		}
		ActionContext.getContext().put("isPay", "no");
		return "doUserList";
	}

	// 更新用户Action
	public String updateUser() {
		boolean flage = false;
		try {
			flage = userService.updateUsers(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!flage) {
			ActionContext.getContext().put("isPay", "no");
		}
		ActionContext.getContext().put("isPay", "yes");
		return "doUserList";
	}

	public String deleteUser() {
		boolean flage = false;
		try {
			flage = userService.deleteUsers(users.getU_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!flage) {
			ActionContext.getContext().put("isPay", "no");
		}
		ActionContext.getContext().put("isPay", "yes");
		return "doUserList";

	}
	public void logoutUser() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("Users");
		try {
			ServletActionContext.getResponse().sendRedirect("admin_index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public PageBean<Users> getPage() {
		return page;
	}

	public void setPage(PageBean<Users> page) {
		this.page = page;
	}

}
