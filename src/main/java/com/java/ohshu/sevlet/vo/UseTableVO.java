package com.java.ohshu.sevlet.vo;

import java.util.Objects;

public class UseTableVO {
	
	private String user_id;
	private String user_pwd;
	private String user_name;
	private int user_age;
	private String user_jumin;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_age() {
		return user_age;
	}
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}
	public String getUser_jumin() {
		return user_jumin;
	}
	public void setUser_jumin(String user_jumin) {
		this.user_jumin = user_jumin;	
	}
	
	
	@Override
	public String toString() {
		return "UserTable [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name=" + user_name + ", user_age="
				+ user_age + ", user_jumin=" + user_jumin + "]";
	}

	


}
