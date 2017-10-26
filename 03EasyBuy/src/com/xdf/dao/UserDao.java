package com.xdf.dao;

import java.util.List;

import com.xdf.bean.Easybuy_User;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-24上午11:43:09
 * 
 * 针对于User的接口
 */
public interface UserDao {

	/**
	 * 用户登录的方法
	 * @param name   用户名
	 * @param password   密码
	 * @return
	 */
	public boolean loginUser(String name, String password);

	/**
	 * 用户的新增
	 * @param user   用户前端传递过来的对象
	 */
	public int addUser(Easybuy_User user);

	/**
	 * 根据用户姓名删除指定的用户
	 * @param name  用户前端传递过来的用户名
	 */
	public int deleteUser(String name);

	/**
	 * 修改指定的用户
	 * @param user用户前端传递过来的对象
	 */
	public int updateUser(Easybuy_User user);

	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	public List<Easybuy_User> selectUsers();

}
