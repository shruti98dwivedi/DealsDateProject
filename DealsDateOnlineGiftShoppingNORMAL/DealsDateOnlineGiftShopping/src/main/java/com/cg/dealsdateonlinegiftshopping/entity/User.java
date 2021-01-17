package com.cg.dealsdateonlinegiftshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {

	
	@Id
	@Column(name = "UserId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(sequenceName = "user_sequence", initialValue = 11600000, allocationSize = 1, name = "user_seq")
	Integer UserId;
	
	@Column(name = "UserName")
	String UserName;
	
	@Column(name = "Password")
	String Password;
	
	@Column(name = "MobileNumber")
	Long MobileNumber;
	
	@Column(name = "GmailId")   
	String GmailId;

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getGmailId() {
		return GmailId;
	}

	public void setGmailId(String gmailId) {
		GmailId = gmailId;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", MobileNumber="
				+ MobileNumber + ", GmailId=" + GmailId + "]";
	}
	

	public User() { }

	public User(Integer userId, String userName, String password, Long mobileNumber, String gmailId) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		MobileNumber = mobileNumber;
		GmailId = gmailId;
	}
}
