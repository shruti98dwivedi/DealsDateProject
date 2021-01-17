package com.cg.dealsdateonlinegiftshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CartItem_table")
public class CartItem {

	
	@Id
	@Column(name = "CartItemId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartItem_seq")
	@SequenceGenerator(sequenceName = "cartItem_seq", initialValue = 100, allocationSize = 1, name = "cartItem_seq")
	private Integer CartItemId;


	@Column(name="CartItemName")
	private String CartItemName;
	
	@Column(name="ProductName")
	private String ProductName;

	@Column(name="CartItemPrice")
	private Integer CartItemPrice;
	
	@Column(name="ProductPrice")
	private double productPrice;

	@Column(name="CartItemQuantity")
	private Integer CartItemQuantity;
	



	public CartItem() {
	super();
	}

	public CartItem(Integer CartItemId, String CartItemName, Integer CartItemPrice, Integer CartItemQuantity) {
	super();
	this.CartItemId = CartItemId;
	this.CartItemName = CartItemName;
	this.CartItemPrice = CartItemPrice;
	this.CartItemQuantity = CartItemQuantity;

	}

	
	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double d) {
		this.productPrice = d;
	}

	public Integer getCartItemId() {
	return CartItemId;
	}

	public void setCartItemId(Integer CartItemId) {
	this.CartItemId = CartItemId;
	}

	public String getCartItemName() {
	return CartItemName;
	}

	public void setCartItemName(String CartItemName) {
	this.CartItemName = CartItemName;
	}

	public Integer getCartItemPrice() {
	return CartItemPrice;
	}

	public void setCartItemPrice(Integer CartItemPrice) {
	this.CartItemPrice = CartItemPrice;
	}
	public Integer getCartItemQuantity() {
	return CartItemQuantity;
	}

	public void setCartItemQuantity(Integer CartItemQuantity) {
	this.CartItemQuantity = CartItemQuantity;
	}
}
