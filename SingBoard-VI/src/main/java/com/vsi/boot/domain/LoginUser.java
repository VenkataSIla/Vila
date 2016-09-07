package com.vsi.boot.domain;

public class LoginUser {
	
	private String username = null;
	private String password = null;
	private String userType = null;
	
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", password=" + password
				+ ", userType=" + userType + "]";
	}
	

}
