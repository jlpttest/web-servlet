package com.demo.entities;

public class User {

	private long id;
	private String userName;
	private String email;
	private String avatar;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public User(long id, String userName, String email, String avatar) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.avatar = avatar;
	}

	public User( String userName, String email, String avatar) {
		this.userName = userName;
		this.email = email;
		this.avatar = avatar;
	}
	
	public User() {
		super();
	}

}
