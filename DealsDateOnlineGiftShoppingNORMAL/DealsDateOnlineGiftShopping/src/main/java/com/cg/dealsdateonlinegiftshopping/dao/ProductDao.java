package com.cg.dealsdateonlinegiftshopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateonlinegiftshopping.entity.Product;
import com.cg.dealsdateonlinegiftshopping.entity.ProductCategory;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	//Fetch List of Categories
	@Query(value="select distinct productCategory from Product")
	public List<String> findListOfCategories();
	
	
	
	//Fetch List of Products by Category
	@Query(value="select p from Product p where p.productCategory=?1")
	//@Query(value="select p from Product p where p.productCategory=:category")
	public List<Product> findListofProductsByCategories(ProductCategory category);
	
	
	//Fetching list of products in ascending order of product price
	public List<Product> findByOrderByProductPriceAsc();
	
	//Fetching list of products in descending order of product price
		public List<Product> findByOrderByProductPriceDesc();
	
}
