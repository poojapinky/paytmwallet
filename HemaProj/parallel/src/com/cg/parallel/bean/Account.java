package com.cg.parallel.bean;

import java.time.LocalDateTime;

public class Account {
	private String mobileNo;
	private String email;
	private String name;
	private double balance;
	private LocalDateTime datet;
	
	public String getMobileNo() {
		return mobileNo;
	}
	public Account(String mobileNo, String email, String name, double balance){
		super();
		this.mobileNo = mobileNo;
		this.email = email;
		this.name = name;
		this.balance = balance;

		// TODO Auto-generated constructor stub
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getDatet() {
		return datet;
	}
	public void setDatet(LocalDateTime datet) {
		this.datet = datet;
	}

}
