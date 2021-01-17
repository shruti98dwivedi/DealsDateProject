package com.cg.dealsdateproductmicroservice.service;

import java.util.List;
import com.cg.dealsdateproductmicroservice.entity.ProductCategory;
import com.cg.dealsdateproductmicroservice.entity.ProductEntity;
import com.cg.dealsdateproductmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateproductmicroservice.model.ProductModel;

public interface ProductService {
	
	
	

	// add products
	public ProductModel addProduct(ProductEntity product) throws ProductNotFoundException;
	
	//delete products
	public boolean deleteProduct(Integer id) throws ProductNotFoundException;

	// returns product with particular productId
	public ProductModel getProductById(Integer id) throws ProductNotFoundException;

	// show list of categories
	public List<String> showListOfCategories() throws ProductNotFoundException;

	// display all products
	public List<ProductModel> displayListOfProducts();

	// display products based on categories
	public List<ProductModel> displayListOfProductByCategory(ProductCategory category) throws ProductNotFoundException;

	// display list of products sorted in ascending order of price
	public List<ProductModel> getListOfProductsOntheBasisOfProductPriceSortingAsc();

	// display list of products sorted in descending order of price
	public List<ProductModel> getListOfProductsOntheBasisOfProductPriceSortingDesc();

	// display list of products sorted in ascending order of price order by category
	public List<ProductModel> getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder(
			ProductCategory category) throws ProductNotFoundException;

	// display list of products sorted in descending order of price order by
	// category
	public List<ProductModel> getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder(
			ProductCategory category)throws ProductNotFoundException;

}
