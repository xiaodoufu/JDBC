package com.xdf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xdf.bean.Easybuy_User;
import com.xdf.dao.UserDao;
import com.xdf.util.BaseDao;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-19上午11:54:03
 * 
 * 针对于user的增删改查
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * 用户登录的方法
	 * @param loginName   用户名
	 * @param password  密码
	 * @return    是否登录成功
	 */
	@Override
	public boolean loginUser(String name, String password) {

		// 定义一个标记 记录用户是否登录成功
		boolean flag = false;
		try {
			// 书写sql 先在dbms中运行一次
			String sql = "SELECT loginName,password FROM easybuy_user where loginName=? and password=?";
			Object[] params = { name, password };
			// 得到结果集
			rs = executeQuery(sql, params);
			// 处理结果集
			if (rs.next()) { // 证明有用户
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			closeConnection();
		}
		return flag;

	}

	/**
	 * 新增用户
	 */
	@Override
	public int addUser(Easybuy_User user) {
		// 书写sql 先在dbms中运行一次
		String sql = "INSERT  INTO easybuy_user(loginname,userName,`password`,sex)"
				+ " VALUES(?,?,?,?)";
		Object[] params = { user.getLoginName(), user.getPassword(),
				user.getUserName(), user.getSex() };
		// Statement执行sql
		int rowNum = executeUpdate(sql, params); // rowNum===》sql语句对数据库中数据的影响行数
		return rowNum;
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public int deleteUser(String name) {
		// 书写sql 先在dbms中运行一次
		String sql = "DELETE FROM easybuy_user WHERE userName=?";
		Object[] params = { name };
		// Statement执行sql
		int rowNum = executeUpdate(sql, params); // rowNum===》sql语句对数据库中数据的影响行数

		return rowNum;
	}

	/**
	 *  修改用户信息
	 *    根据 真实姓名  修改对应的  登录名和密码
	 */
	@Override
	public int updateUser(Easybuy_User user) {
		// 书写sql 先在dbms中运行一次
		String sql = "UPDATE  easybuy_user SET loginName=?,`password`=?  WHERE userName=?";
		Object[] parmas = { user.getLoginName(), user.getPassword(),
				user.getUserName() };
		// Statement执行sql
		int rowNum = executeUpdate(sql, parmas); // rowNum===》sql语句对数据库中数据的影响行数
		return rowNum;
	}

	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<Easybuy_User> selectUsers() {
		// 创建集合用于保存所有的用户
		List<Easybuy_User> lists = new ArrayList<>();
		try {
			// 书写sql 先在dbms中运行一次
			String sql = "SELECT * FROM easybuy_user";
			// 得到结果集
			rs = executeQuery(sql);
			// 处理结果集
			while (rs.next()) {
				// 创建单个用户对象
				Easybuy_User user = new Easybuy_User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setIdentityCode(rs.getString("identityCode"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setType(rs.getInt("type"));
				// 向集合中增加元素
				lists.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			closeConnection();
		}
		return lists;
	}

}
