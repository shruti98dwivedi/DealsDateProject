package com.cg.dealsdateonlinegiftshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "wishlist")
public class WishList {

	

	@Id
	@Column(name = "wishlistId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wishlist_seq")
	@SequenceGenerator(sequenceName = "wishlist_sequence", initialValue = 2020100, allocationSize = 1, name = "wishlist_seq")
	
	private Integer wishlistId;
	
	@Column(name = "productId")
	private Integer productId;
	
	@Column(name = "productName")
	private String productName;
	
	
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "productCategory")
	private ProductCategory productCategory;
	
	@Column(name = "productDescription")
	private String productDescription;

	public Integer getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(Integer wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public WishList() { }
	
	@Override
	public String toString() {
		return "WishList [wishlistId=" + wishlistId + ", productId=" + productId + ", productName=" + productName
				+ ", userId=" + userId + ", price=" + price + ", productCategory=" + productCategory
				+ ", productDescription=" + productDescription + "]";
	}

	public WishList(Integer wishlistId, Integer productId, String productName,Integer userId,Double price, ProductCategory productCategory,String productDescription) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.price = price;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
	}	
}
