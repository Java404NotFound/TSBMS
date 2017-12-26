package com.rjxy.dao;

import java.sql.SQLException;
import java.util.List;

import com.rjxy.bean.PageBean;
import com.rjxy.bean.Users;

public interface UserDao {
/*
 * 分页语句
 * SELECT *
  FROM (SELECT ROWNUM AS rowno, t.*
          FROM users t
         WHERE 
    ROWNUM <=5) table_alias
 WHERE table_alias.rowno >= 3;
 * 
 * 
 */
	public boolean  isUserName(String username)throws SQLException;
	public boolean  updatePassWord(String password,String u_id) throws SQLException ;
	public Users getUsersById(String U_id)throws SQLException;
	public Users logic(Users user) throws SQLException;
	public List<Users> findUserListPage(PageBean<Users> page) throws SQLException ;
	public List<Users> findUserListPage(PageBean<Users> page,String username) throws SQLException ;
	public boolean  insertUsers(Users user) throws SQLException ;
	public boolean updateUsers(Users user) throws SQLException ;
	public boolean deleteUsers(String u_ids) throws SQLException ;
	public int findUserListsiex() throws SQLException;
	public int findUserListsiex2(String username) throws SQLException;


	

}
