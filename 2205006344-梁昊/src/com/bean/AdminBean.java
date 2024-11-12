package com.bean;

public class AdminBean {

	// 定义三个私有成员变量：account（账号）、password（密码）、type（类型）
	private String account;
	private String password;
	private String type;
	// 带参数的构造函数，用于初始化对象的成员变量
	public AdminBean(String account, String password, String type) {
		super();
		// 调用父类的无参构造函数（这里如果父类没有无参构造函数可能会导致编译错误）
		// 将传入的参数赋值给成员变量 account
		this.account = account;
		// 将传入的参数赋值给成员变量 password
		this.password = password;
		// 将传入的参数赋值给成员变量 type
		this.type = type;
	}


	// 无参构造函数，默认的构造方法
	public AdminBean() {
		//调用父类的无参构造函数
		super();
	}

	// 以下是三个成员变量的 getter 和 setter 方法
     // 获取 account 变量值的方法
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
