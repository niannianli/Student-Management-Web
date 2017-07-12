package com.nian.student.pojo;

import java.util.Date;

public class User {
	
	private Integer id;
	private String name;
	private String address;
	private Date dob;
	private String username;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}

//if we have a big application
//we add html, java in jsp

// we also use spring tag, instead of html tag
// jstl: jsp tag library: no need to write all the code
// internally convert to java code: no need to write