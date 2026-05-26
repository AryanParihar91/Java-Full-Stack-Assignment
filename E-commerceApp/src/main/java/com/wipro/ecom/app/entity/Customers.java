package com.wipro.ecom.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customers {

	@Id
	@Column(name = "customer_id")
	private int cid;

	@Column(name = "customer_name")
	private String cname;
	private String email;
	private String address;
	

	public Customers() {}


	public Customers(int cid, String cname, String email, String address) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.address = address;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
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


	@Override
	public String toString() {
		return "Customers [cid=" + cid + ", cname=" + cname + ", email=" + email + ", address=" + address + "]";
	}

	
}
