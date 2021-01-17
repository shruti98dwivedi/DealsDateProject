package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import com.cg.dealsdateonlinegiftshopping.entity.Product;
import com.cg.dealsdateonlinegiftshopping.entity.ProductCategory;

public interface ProductServiceIntf {
	
	//add products
	public Product addProduct(Product product);
	//show list of categories
	public List<String> showListOfCategories();
	//display all products
	public List<Product> displayListOfProducts();
	//display products based on categories
	public List<Product> displayListOfProductByCategory(ProductCategory category);
	
	public List<Product> getListOfProductsOntheBasisOfProductPriceSortingAsc();
	
	public List<Product> getListOfProductsOntheBasisOfProductPriceSortingDesc();
	
}
