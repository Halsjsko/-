package com.mysqld;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.util.DBUtilZ;



public class  Mysqld{

	static Connection con=DBUtilZ.con;
//upDate 方法：
//用于执行数据库的更新操作（如 INSERT、UPDATE、DELETE 等）。
//接受一个 sqlStr 表示要执行的 SQL 语句，和一个 data 字符串数组用于设置预编译语句中的参数。
//通过创建 PreparedStatement 对象来准备执行 SQL 语句。如果 data 数组为空，直接执行更新操作；
// 否则，为预编译语句设置参数后执行更新操作，并返回受影响的行数。如果在执行过程中发生 SQLException，
// 则打印错误信息并返回 -1 表示操作失败。
	public static int  upDate(String sqlStr,String data[]) {
		
		PreparedStatement preSql;
		int num;
		try {
			
			preSql=con.prepareStatement(sqlStr);
			if(data==null) {
				num=preSql.executeUpdate();
			}else {
				for(int i=0;i<data.length;i++) {

					preSql.setString(i+1,data[i]);
				}
				System.out.println(preSql);
				num=preSql.executeUpdate();
				
			}
			return num;
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}

	//QueryData 方法：
//	用于执行数据库的查询操作。
//	同样接受一个 sqlStr 表示要执行的查询 SQL 语句，
//	和一个可选的 data 字符串数组用于设置预编译语句中的参数。
//	创建 PreparedStatement 对象并设置可能的参数后，
//	执行查询操作并返回查询结果的 ResultSet 对象。如果在执行过程中发生 SQLException，则返回 null 。
	public static ResultSet  QueryData(String sqlStr,String data[]) {
		
		ResultSet rs = null;
		PreparedStatement preSql;
		try {
			
			preSql=con.prepareStatement(sqlStr);
			
			if(data!=null) {
				for(int i=0;i<data.length;i++) {

					preSql.setString(i+1,data[i]);
				}
			}
			
			
			System.out.println(preSql);
			rs=preSql.executeQuery();
	
			return rs;
			
			
		} catch (SQLException e) {
			//e.printStackTrace();
			return rs;
		}
		
	}
}
