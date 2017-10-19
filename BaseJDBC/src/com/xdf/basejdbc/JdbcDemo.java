package com.xdf.basejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * 失去一日甚易,欲得回已无途！
 *  
 * @author 小葱拌豆腐
 * 2017-10-19上午11:54:03
 * 
 * 
 * 
 * 
 * 第一次使用JDBC访问我们的mysql数据库
 * 01.把mysql数据库需要的驱动包引入到我们的项目中===》使用反射机制加载驱动包
 *     因为反射是在程序运行期间，动态的加载我们需要的类！
 *     程序在编译期间，这个类可以不在！
 * 02.创建与数据库的连接   需要四要素    
 * 
 */
public class JdbcDemo {

	public static void main(String[] args) {
		Connection con = null; // 连接对象
		Statement stmt = null; // 执行sql语句的对象
		ResultSet rs = null; // 返回的结果集
		try {
			// 1.使用反射机制加载驱动包
			Class.forName("com.mysql.jdbc.Driver");
			// 2.创建与数据库的连接
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/easybuy?useUnicode=true&characterEncoding=utf8",
							"root", "");
			// 3.1 书写sql 现在dbms中运行一次
			String sql = "SELECT * FROM easybuy_user";
			// 3.2 执行sql
			stmt = con.createStatement();
			// 4.1 得到结果集
			rs = stmt.executeQuery(sql);
			// 4.2 处理结果集
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
				System.out.println("编号：" + id);
				System.out.println("登录名：" + loginName);
				System.out.println("真实姓名：" + userName);
				System.out.println("密码：" + password);
				System.out.println("性别：" + sex);
				System.out.println("身份证：" + identityCode);
				System.out.println("邮箱：" + email);
				System.out.println("手机号：" + mobile);
				System.out.println("用户类型：" + type);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
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
