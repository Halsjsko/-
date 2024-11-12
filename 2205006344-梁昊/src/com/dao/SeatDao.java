package com.dao;

import java.sql.ResultSet;

import com.dao.impl.DishDaoImpl;
import com.dao.impl.SeatDaoImpl;
import com.mysqld.Mysqld;

public class SeatDao implements   SeatDaoImpl{
      //保存座位信息的方法
	@Override
	public int saveSeat(String id, String peo) {
		// 创建包含座位 ID 和人数的字符串数组
		String data[]= {id,peo};
		// 调用 Mysqld 的 upDate 方法执行插入数据的 SQL 语句，并将返回值赋给 a
		int a = Mysqld.upDate("insert into s_seat (d_id,d_mpeo) VALUES (?,?)", data);
		// 返回操作结果
		return a;
	}
	// 删除座位信息的方法，根据座位 ID 进行删除
	@Override
	public int delSeat(String id) {
		// 创建包含座位 ID 的字符串数组
		String data[]= {id};
		// 调用 Mysqld 的 upDate 方法执行删除数据的 SQL 语句，并将返回值赋给 a
		int a = Mysqld.upDate("DELETE FROM s_seat where d_id=?", data);
		// 返回操作结果
		return a;
	}
	// 更新座位信息的方法
	@Override
	public int upSeat(String... data) {
		// 调用 Mysqld 的 upDate 方法执行更新数据的 SQL 语句，并将返回值赋给 a
		int a = Mysqld.upDate("update s_seat set d_id=?,d_mpeo=? where d_id=? and d_sta='0'", data);
		// 返回操作结果
		return a;
	}
	// 根据指定的座位 ID 查询座位信息的方法
	@Override
	public ResultSet  showSeat(String... data) {
		// 调用 Mysqld 的 QueryData 方法执行查询数据的 SQL 语句，并将结果集赋给 rs
		ResultSet rs = Mysqld.QueryData("select * from s_seat where d_id=?", data);
		return rs;
	}
	// 查询所有座位信息的方法
	@Override
	public ResultSet  showSeat() {
		// 调用 Mysqld 的 QueryData 方法执行查询所有数据的 SQL 语句，并将结果集赋给 rs
		ResultSet rs = Mysqld.QueryData("select * from s_seat ", null);
		return rs;
	}

}
