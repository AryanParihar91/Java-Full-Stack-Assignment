package com.wipro.ecom.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id
	@Column(name = "order_id")
	private int oid;
	
	@Column(name = "order_status")
	private String status;
	
	@Column(name = "order_amount")
	private double orderAmount;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
    public Orders(int oid, String status, double orderAmount) {
		super();
		this.oid = oid;
		this.status = status;
		this.orderAmount = orderAmount;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", status=" + status + ", amount=" + orderAmount + "]";
	}

}
