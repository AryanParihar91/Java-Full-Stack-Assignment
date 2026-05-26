package com.wipro.ecom.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	@Column(name = "payment_id")
	private int ptid;
	@Column(name = "payment_mode")
	private String paymentMode;
	private double amount;
	private String status;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int ptid, String paymentMode, double amount, String status) {
		super();
		this.ptid = ptid;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.status = status;
	}

	public int getPtid() {
		return ptid;
	}

	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [ptid=" + ptid + ", paymentMode=" + paymentMode + ", amount=" + amount + ", status=" + status
				+ "]";
	}

	
}
