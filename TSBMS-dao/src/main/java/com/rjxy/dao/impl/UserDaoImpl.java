package com.rjxy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.rjxy.bean.PageBean;
import com.rjxy.bean.Users;
import com.rjxy.dao.UserDao;
import com.rjxy.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {
	/**
	 * 用户登录
	 * 
	 * @throws SQLException
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public Users logic(Users user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM users where username=? and password=?";
		Users users = runner.query(sql, new BeanHandler<Users>(Users.class), user.getUsername(), user.getPassword());
		return users;
	}

	/**
	 * 分页查询数据 无模糊查询条件
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public List<Users> findUserListPage(PageBean<Users> page) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM users t  WHERE ROWNUM <?)  table_alias  WHERE  table_alias.rowno >=?";
		List<Users> list = runner.query(sql, new BeanListHandler<Users>(Users.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}

	/**
	 * 添加User对象数据
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 */
	@Override
	public boolean insertUsers(Users user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into users(u_id,username,gender,age,phone,address,role,password) values(?,?,?,?,?,?,?,?)";
		int update = runner.update(sql, user.getU_id(), user.getUsername(), user.getGender(), user.getAge(),
				user.getPhone(), user.getAddress(), user.getRole(), user.getPassword());
		return update > 0 ? true : false;
	}

	/**
	 * 修改User对象数据
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 * 
	 */
	@Override
	public boolean updateUsers(Users user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update users set username=?,gender=?,age=?,phone=?,address=?,role=? where u_id=?";
		int update = runner.update(sql, user.getUsername(), user.getGender(), user.getAge(), user.getPhone(),
				user.getAddress(), user.getRole(), user.getU_id());
		return update > 0 ? true : false;
	}

	/**
	 * 删除User对象数据
	 * 
	 * @param李湘鄂
	 * @serialData 2017-11-5
	 * 
	 */
	@Override
	public boolean deleteUsers(String u_ids) throws SQLException {
		String sql = "delete from users where u_id = '" + u_ids + "'";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int update = runner.update(sql);
		return update > 0 ? true : false;
	}

	/**
	 * 
	 * 返回无条件查询的总条数
	 * 
	 * @see com.rjxy.dao.UserDao#findUserListsiex()
	 */
	@Override
	public int findUserListsiex() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from users";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler()) + "");
		return query;
	}

	/**
	 * 
	 * 返回 username 条件查询的总条数
	 * 
	 * @see com.rjxy.dao.UserDao#findUserListsiex()
	 */
	@Override
	public int findUserListsiex2(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from users where username like ?";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), "%" + username + "%") + "");
		return query;
	}

	/**
	 * 
	 * 分页查询的User数据
	 * 
	 * @see com.rjxy.dao.UserDao#findUserListsiex()
	 */
	@Override
	public List<Users> findUserListPage(PageBean<Users> page, String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM (SELECT ROWNUM AS rowno, t.* FROM users t  WHERE ROWNUM <?  and username like ?)  table_alias  WHERE  table_alias.rowno >=?";
		List<Users> list = runner.query(sql, new BeanListHandler<Users>(Users.class),
				((page.getCurrentCount() - 1) * page.getCurrentPage() + 1) + page.getCurrentPage(),
				"%" + username + "%", ((page.getCurrentCount() - 1) * page.getCurrentPage() + 1));
		return list;
	}

	/**
	 * 
	 * 根据ID获得User
	 * 
	 * @see com.rjxy.dao.UserDao#getUsersById(java.lang.String)
	 */
	@Override
	public Users getUsersById(String U_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT * FROM users where u_id=?";
		Users users = runner.query(sql, new BeanHandler<Users>(Users.class), U_id);
		return users;
	}

	/**
	 * 根据username获得User (non-Javadoc)
	 * 
	 * @see com.rjxy.dao.UserDao#isUserName(java.lang.String)
	 */
	@Override
	public boolean isUserName(String username) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " SELECT count(1) FROM users where username=?";
		int query = Integer.parseInt(runner.query(sql, new ScalarHandler(), username) + "");
		return query > 0 ? false : true;
	}

	/**
	 * 修改密码 (non-Javadoc)
	 * 
	 * @see com.rjxy.dao.UserDao#isUserName(java.lang.String)
	 */
	@Override
	public boolean updatePassWord(String password, String u_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " update users set password=? where u_id=?";
		int update = runner.update(sql, password, u_id);
		return update > 0 ? true : false;
	}

}
