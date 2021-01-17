package com.cg.dealsdateproductmicroservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.dealsdateproductmicroservice.entity.ProductCategory;
import com.cg.dealsdateproductmicroservice.entity.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {

	// Fetch List of Categories
	@Query(value = "select distinct productCategory from ProductEntity")
	public List<String> findListOfCategories();

	// Fetching list of products in ascending order of product price
	public List<ProductEntity> findByOrderByProductPriceAsc();

	// Fetching list of products in descending order of product price
	public List<ProductEntity> findByOrderByProductPriceDesc();

	// Fetch List of Products by Category
	@Query(value = "select p from ProductEntity p where p.productCategory=?1")
	public List<ProductEntity> findListofProductsByCategories(ProductCategory category);

	// Fetching list of products in ascending order of product price for specific
	// category
	public List<ProductEntity> findByProductCategoryOrderByProductPriceAsc(ProductCategory category);

	// Fetching list of products in descending order of product price for specific
	// category
	public List<ProductEntity> findByProductCategoryOrderByProductPriceDesc(ProductCategory category);
	
	public boolean existsProductByProductCategory(ProductCategory category);

}
