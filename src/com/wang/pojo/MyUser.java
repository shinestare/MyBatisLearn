package com.wang.pojo;

public class MyUser {
	private int id;
	private String username;
	private String password;
	
	// 构造函数，为了关联查询的时候构造函数方式用
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	// 构造函数，为了关联查询的时候构造函数方式用
	public MyUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
