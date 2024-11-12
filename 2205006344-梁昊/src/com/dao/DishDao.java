package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.DishBean;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.DishDaoImpl;
import com.mysqld.Mysqld;

public class DishDao implements   DishDaoImpl{
      //保持菜品的方法
	@Override
	public int saveDish(DishBean disBean) {
		// 准备要插入数据库的菜品信息数据
		String data[]= {disBean.getDname(),disBean.getDkouwei(),disBean.getDjiage(),disBean.getD_jianjie()};
		// 执行数据库插入操作，并获取受影响的行数
		int a = Mysqld.upDate("insert INTO s_dish (d_name,d_kouwei,d_jiage,d_jianjie) VALUES(?,?,?,?)", data);
		return a;
	}
	// 删除菜品的方法
	@Override
	public int delDish(DishBean disBean) {
		// 准备要删除菜品的名称数据
		String data[]= {disBean.getDname()};
        // 执行数据库删除操作，并获取受影响的行数
		int a = Mysqld.upDate("DELETE FROM s_dish where d_name=?", data);
		return a;
	}
	// 更新菜品的方法
	@Override
	public int upDish(DishBean disBean, String name) {
		// 准备要更新的菜品信息数据和原菜品名称
		String data[]= {disBean.getDname(),disBean.getDkouwei(),disBean.getD_jianjie(),disBean.getD_jianjie(),name};
		// 执行数据库更新操作，并获取受影响的行数
		int a = Mysqld.upDate("UPDATE s_dish set d_name=?,d_kouwei=?,d_jiage=?,d_jianjie=? where d_name=?", data);
		
		return a;
	}
	// 根据菜品名称查询菜品的方法
	@Override
	public ResultSet showDish(String name) {
		// 准备要查询的菜品名称数据
		String data[]= {name};
		// 执行数据库查询操作，并获取结果集
		ResultSet rs = Mysqld.QueryData("select * from s_dish where d_name=?", data);
		return rs;
	}
	// 查询所有菜品的方法
	@Override
	public ResultSet showDish() {
		// 执行数据库查询操作获取所有菜品的结果集
		ResultSet rs = Mysqld.QueryData("select * from s_dish ", null);
		return rs;
	}
}
