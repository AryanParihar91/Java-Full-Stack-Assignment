package com.wipro.ecom.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	@Column(name = "order_id")
	private int oid;

	@Column(name = "order_status")
	private String status;

	@Column(name = "order_amount")
	private double orderAmount;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customers customer;

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

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", status=" + status + ", orderAmount=" + orderAmount + ", customer=" + customer
				+ "]";
	}

}
