package com.cg.dealsdateproductmicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="deals_date_product_table")
public class ProductEntity {
	
	@Id
	@Column(name="product_id",nullable=false)
	private int productId;
	
    @Column(name="product_name",nullable=false)
    private String productName;
    
    @Column(name="product_price",nullable=false)
    private double productPrice;
    
    @Column(name="product_color",nullable=false) 
    private String productColor;
    
    @Enumerated(EnumType.STRING)
    @Column(name="product_category",nullable=false)
    private ProductCategory productCategory;
    
    @Column(name="product_quantiy",nullable=false)
    private int productQuantity;
    
    @Column(name="product_specification")
    private String productSpecification;
    
    @Column(name="product_imageUrl")
    private String imageUrl;

    
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

    
    
}
