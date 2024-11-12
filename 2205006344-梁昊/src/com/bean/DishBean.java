package com.bean;

public class DishBean {
	// 定义了四个私有成员变量：菜品名称（dname）、菜品口味（dkouwei）、菜品价格（djiage）、菜品简介（d_jianjie）
	private String dname;
	private String dkouwei;
	private String djiage;
	private String d_jianjie;
	// 以下是各个成员变量的 getter 方法，用于获取成员变量的值
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDkouwei() {
		return dkouwei;
	}
	// 以下是各个成员变量的 setter 方法，用于设置成员变量的值
	public void setDkouwei(String dkouwei) {
		this.dkouwei = dkouwei;
	}
	public String getDjiage() {
		return djiage;
	}
	public void setDjiage(String djiage) {
		this.djiage = djiage;
	}
	public String getD_jianjie() {
		return d_jianjie;
	}
	public void setD_jianjie(String d_jianjie) {
		this.d_jianjie = d_jianjie;
	}
	// 带参数的构造函数，用于初始化对象的成员变量
	public DishBean(String dname, String dkouwei, String djiage, String d_jianjie) {
		super();
		this.dname = dname;
		this.dkouwei = dkouwei;
		this.djiage = djiage;
		this.d_jianjie = d_jianjie;
	}
	// 无参构造函数，提供默认的构造方法
	public DishBean() {
		super();
	}

}
