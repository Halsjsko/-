package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.dao.impl.AdminDaoImpl;

import com.mysqld.Mysqld;
import com.util.DBUtilZ;

public class AdminDao implements   AdminDaoImpl{
	// 登录管理员的方法
	@Override
	public String LoginAdmin(String account, String password) {
		// 创建一个包含账号和密码的数组
		String data[]= {account,password};
		//执行数据库查询操作，并获取结果集
		ResultSet rs = Mysqld.QueryData("select * from s_user where s_admin=? and s_password=?", data);
		try {
			// 遍历结果集
			while(rs.next()) {
				// 获取权限字段的值
				String s_type=rs.getString("s_type");
				//根据权限值返回不同的结果
				if(s_type.equals("1")) {
					//管理员
					return "1";
				}else
				if(s_type.equals("2")) {
					//管理员
					return "2";
				}else {
					return "0";
				}
			}
		} catch (SQLException e) {
			// 打印异常信息
			e.printStackTrace();
		}
		return "0";
	}
	// 注册管理员的方法
	@Override
	public int RegistAdmin(AdminBean admin) {
		// 准备要插入数据库的数据
		String data[]= { admin.getAccount(), admin.getPassword(),"2"};
          //执行数据库插入操作，并获取受影响的行数
		int a = Mysqld.upDate("insert into s_user (s_admin,s_password,s_type) VALUES(?,?,?)", data);
		
		return a;
	}
	
	
	

}
