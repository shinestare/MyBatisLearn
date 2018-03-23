package com.wang.pojo;

public class Author {
	private int id;
	private MyUser user;
	private String realName;
	private String IDCard;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MyUser getUser() {
		return user;
	}
	public void setUser(MyUser user) {
		this.user = user;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String IDCard) {
		this.IDCard = IDCard;
	}
	
}
