package com.cg.dealsdatecartmicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@Column(name = "cartId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_seq")
	@SequenceGenerator(sequenceName = "cart_sequence", initialValue = 2020100, allocationSize = 1, name = "cart_seq")

	private int cartId;

	@Column(name = "productId")
	private int productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "userId")
	private int userId;

	@Column(name = "productPrice")
	private double productPrice;

	@Column(name = "productQuantity")
	private int productQuantity;

	@Column(name = "productColor")
	private String productColor;

	@Column(name = "productCategory")
	private String productCategory;

	@Column(name = "productSpecification")
	private String productSpecification;

	@Column(name = "imageUrl")
	private String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	

	public Cart() {
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", productName=" + productName
				+ ", userId=" + userId + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", productColor=" + productColor + ", productCategory=" + productCategory + ", productSpecification="
				+ productSpecification + ", imageUrl=" + imageUrl + "]";
	}

	public Cart(int cartId, int productId, String productName, int userId, double productPrice,
			int productQuantity, String productColor, String productCategory, String productSpecification,
			String imageUrl) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productColor = productColor;
		this.productCategory = productCategory;
		this.productSpecification = productSpecification;
		this.imageUrl = imageUrl;
	}

}