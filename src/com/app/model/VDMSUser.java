package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tab")
public class VDMSUser {
	
public VDMSUser() {
		super();
	}
public VDMSUser(int userId) {
		super();
		this.userId = userId;
	}
@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email
				+ ", address=" + address + ", password=" + password + "]";
	}
public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	@Column 
	@GeneratedValue(strategy = GenerationType.AUTO)
private int userId;
	@Column
private String userName;
	@Column
private String mobileNumber;
	@Column
private String email;
	@Column
private String address;
	@Column
private String password;
}
