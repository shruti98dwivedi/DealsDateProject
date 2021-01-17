package com.cg.dealsdateonlinegiftshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Order_table")
public class Order {

	@Id
	@Column(name = "OrderId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(sequenceName = "order_seq", initialValue = 100, allocationSize = 1, name = "order_seq")
	private Integer OrderId;


	@Column(name="OrderStatus")
	private String OrderStatus;

	@Column(name="PaymentMethod")
	private String PaymentMethod;

	@Column(name="OrderQuantity")
	private Integer OrderQuantity;



	public Order() {
	super();
	}

	public Order(Integer OrderId, String OrderStatus, String PaymentMethod, Integer OrderQuantity) {
	super();
	this.OrderId = OrderId;
	this.OrderStatus = OrderStatus;
	this.PaymentMethod = PaymentMethod;
	this.OrderQuantity = OrderQuantity;

	}

	public Integer getOrderId() {
	return OrderId;
	}

	public void setOrderId(Integer OrderId) {
	this.OrderId = OrderId;
	}

	public String getOrderStatus() {
	return OrderStatus;
	}

	public void setOrderStatus(String OrderStatus) {
	this.OrderStatus = OrderStatus;
	}

	public String getPaymentMethod() {
	return PaymentMethod;
	}

	public void setPaymentMethod(String PaymentMethod) {
	this.PaymentMethod = PaymentMethod;
	}
	public Integer getOrderQuantity() {
	return OrderQuantity;
	}

	public void setOrderQuantity(Integer OrderQuantity) {
	this.OrderQuantity = OrderQuantity;
	}
}

