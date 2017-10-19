package com.xdf.basejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * ʧȥһ������,���û�����;��
 *  
 * @author С�а趹��
 * 2017-10-19����11:54:03
 * 
 * 
 * 
 * 
 * ��һ��ʹ��JDBC�������ǵ�mysql���ݿ�
 * 01.��mysql���ݿ���Ҫ�����������뵽���ǵ���Ŀ��===��ʹ�÷�����Ƽ���������
 *     ��Ϊ�������ڳ��������ڼ䣬��̬�ļ���������Ҫ���࣡
 *     �����ڱ����ڼ䣬�������Բ��ڣ�
 * 02.���������ݿ������   ��Ҫ��Ҫ��    
 * 
 */
public class JdbcDemo {

	public static void main(String[] args) {
		Connection con = null; // ���Ӷ���
		Statement stmt = null; // ִ��sql���Ķ���
		ResultSet rs = null; // ���صĽ����
		try {
			// 1.ʹ�÷�����Ƽ���������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.���������ݿ������
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 ��дsql ����dbms������һ��
			String sql = "SELECT * FROM easybuy_user";
			// 3.2 ִ��sql
			stmt = con.createStatement();
			// 4.1 �õ������
			rs = stmt.executeQuery(sql);
			// 4.2 ��������
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginName = rs.getString("loginName");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int sex = rs.getInt("sex");
				String identityCode = rs.getString("identityCode");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				int type = rs.getInt("type");
				System.out.println("��ţ�" + id);
				System.out.println("��¼����" + loginName);
				System.out.println("��ʵ������" + userName);
				System.out.println("���룺" + password);
				System.out.println("�Ա�" + sex);
				System.out.println("���֤��" + identityCode);
				System.out.println("���䣺" + email);
				System.out.println("�ֻ��ţ�" + mobile);
				System.out.println("�û����ͣ�" + type);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
