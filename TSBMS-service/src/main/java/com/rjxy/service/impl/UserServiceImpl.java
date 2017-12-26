package com.rjxy.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rjxy.bean.PageBean;
import com.rjxy.bean.Users;
import com.rjxy.dao.UserDao;
import com.rjxy.dao.impl.UserDaoImpl;
import com.rjxy.service.UserService;
import com.rjxy.utils.DataSourceUtils;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();

	@Override
	public PageBean<Users> findUsersListPage(PageBean<Users> page, String username) throws SQLException {
		try {
			DataSourceUtils.startTransaction();
			int listsiex = 0;
			List<Users> list = null;
			if (username.equals("")) {
				listsiex = userdao.findUserListsiex();
				list = userdao.findUserListPage(page);
			} else if (!username.equals("")) {
				listsiex = userdao.findUserListsiex2(username);
				list = userdao.findUserListPage(page, username);
			}
			page.setTotalCount(listsiex);
			if (listsiex % page.getCurrentPage() == 0) {
				page.setTotalPage(listsiex / page.getCurrentPage());
			} else {
				page.setTotalPage(listsiex / page.getCurrentPage() + 1);
			}

			page.setList(list);
			DataSourceUtils.commitAndRelease();
		} catch (SQLException e) {
			try {
				DataSourceUtils.rollback();
			} catch (SQLException e1) {
				System.out.println("出现错误事物回滚");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public boolean updateUsers(Users users) throws SQLException {
		return userdao.updateUsers(users);
	}

	@Override
	public boolean insertUsers(Users users) throws SQLException {
		return userdao.insertUsers(users);
	}

	@Override
	public boolean deleteUsers(String u_ids) throws SQLException {
		return userdao.deleteUsers(u_ids);
	}

	@Override
	public Users logic(Users user) throws SQLException {
		Users users = userdao.logic(user);
		return users;
	}

	@Override
	public boolean isUserName(String username) throws SQLException {

		return userdao.isUserName(username);
	}

	@Override
	public Users getUsersById(String U_id) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.getUsersById(U_id);
	}

	@Override
	public boolean updatePassWord(String password, String u_id) throws SQLException {
	
		return userdao.updatePassWord(password, u_id);
	}

}
