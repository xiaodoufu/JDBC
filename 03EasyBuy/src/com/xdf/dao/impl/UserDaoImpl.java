package com.xdf.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xdf.bean.Easybuy_User;
import com.xdf.dao.UserDao;
import com.xdf.util.BaseDao;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-19����11:54:03
 * 
 * �����user����ɾ�Ĳ�
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * �û���¼�ķ���
	 * @param loginName   �û���
	 * @param password  ����
	 * @return    �Ƿ��¼�ɹ�
	 */
	@Override
	public boolean loginUser(String name, String password) {

		// ����һ����� ��¼�û��Ƿ��¼�ɹ�
		boolean flag = false;
		try {
			// ��дsql ����dbms������һ��
			String sql = "SELECT loginName,password FROM easybuy_user where loginName=? and password=?";
			Object[] params = { name, password };
			// �õ������
			rs = executeQuery(sql, params);
			// ���������
			if (rs.next()) { // ֤�����û�
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			closeConnection();
		}
		return flag;

	}

	/**
	 * �����û�
	 */
	@Override
	public int addUser(Easybuy_User user) {
		// ��дsql ����dbms������һ��
		String sql = "INSERT  INTO easybuy_user(loginname,userName,`password`,sex)"
				+ " VALUES(?,?,?,?)";
		Object[] params = { user.getLoginName(), user.getPassword(),
				user.getUserName(), user.getSex() };
		// Statementִ��sql
		int rowNum = executeUpdate(sql, params); // rowNum===��sql�������ݿ������ݵ�Ӱ������
		return rowNum;
	}

	/**
	 * ɾ���û���Ϣ
	 */
	@Override
	public int deleteUser(String name) {
		// ��дsql ����dbms������һ��
		String sql = "DELETE FROM easybuy_user WHERE userName=?";
		Object[] params = { name };
		// Statementִ��sql
		int rowNum = executeUpdate(sql, params); // rowNum===��sql�������ݿ������ݵ�Ӱ������

		return rowNum;
	}

	/**
	 *  �޸��û���Ϣ
	 *    ���� ��ʵ����  �޸Ķ�Ӧ��  ��¼��������
	 */
	@Override
	public int updateUser(Easybuy_User user) {
		// ��дsql ����dbms������һ��
		String sql = "UPDATE  easybuy_user SET loginName=?,`password`=?  WHERE userName=?";
		Object[] parmas = { user.getLoginName(), user.getPassword(),
				user.getUserName() };
		// Statementִ��sql
		int rowNum = executeUpdate(sql, parmas); // rowNum===��sql�������ݿ������ݵ�Ӱ������
		return rowNum;
	}

	/**
	 * ��ѯ�����û���Ϣ
	 */
	@Override
	public List<Easybuy_User> selectUsers() {
		// �����������ڱ������е��û�
		List<Easybuy_User> lists = new ArrayList<>();
		try {
			// ��дsql ����dbms������һ��
			String sql = "SELECT * FROM easybuy_user";
			// �õ������
			rs = executeQuery(sql);
			// ���������
			while (rs.next()) {
				// ���������û�����
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
				// �򼯺�������Ԫ��
				lists.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			closeConnection();
		}
		return lists;
	}

}