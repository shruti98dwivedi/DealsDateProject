package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateonlinegiftshopping.dao.ProductDao;
import com.cg.dealsdateonlinegiftshopping.entity.Product;
import com.cg.dealsdateonlinegiftshopping.entity.ProductCategory;

@Service
public class ProductServiceImpl implements ProductServiceIntf {
	
	@Autowired
	private ProductDao repo;

	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public List<String> showListOfCategories() {
		return repo.findListOfCategories();
	}

	@Override
	public List<Product> displayListOfProducts() {
		return repo.findAll();
	}

	@Override
	public List<Product> displayListOfProductByCategory(ProductCategory category) {
		return repo.findListofProductsByCategories(category);
		}

	@Override
	public List<Product> getListOfProductsOntheBasisOfProductPriceSortingAsc() {
		return repo.findByOrderByProductPriceAsc();
	}

	@Override
	public List<Product> getListOfProductsOntheBasisOfProductPriceSortingDesc() {
		return repo.findByOrderByProductPriceDesc();
	}

}
