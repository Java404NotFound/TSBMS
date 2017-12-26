package com.rjxy.service;

import java.sql.SQLException;


import com.rjxy.bean.PageBean;
import com.rjxy.bean.Users;

public interface UserService {
	public Users logic(Users user) throws SQLException;
	public  PageBean<Users> findUsersListPage(PageBean<Users> page,String username) throws SQLException ;
	public boolean updateUsers(Users users) throws SQLException ;
	public boolean insertUsers(Users users) throws SQLException ;
	public boolean deleteUsers(String u_ids) throws SQLException ;
	public boolean isUserName(String username) throws SQLException;
	public Users getUsersById(String U_id)throws SQLException;
	public boolean  updatePassWord(String password,String u_id) throws SQLException ;
}
