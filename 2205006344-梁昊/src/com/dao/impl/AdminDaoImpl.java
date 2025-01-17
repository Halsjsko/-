package com.dao.impl;

import com.bean.AdminBean;

/**
 * 这个写一个用户登录与注册的一个接口
 * @author laterstage
 *
 */
public interface AdminDaoImpl {

	
	/**
	 * 返回1代表成功 
	 * 0代表失败
	 * @param account
	 * @param password
	 * @return
	 */
	public String LoginAdmin(String account,String password);
	
	/**
	 * 注册功能
	 * @param account
	 * @param password
	 * @return
	 */
	public int RegistAdmin(AdminBean admin);
	
}
