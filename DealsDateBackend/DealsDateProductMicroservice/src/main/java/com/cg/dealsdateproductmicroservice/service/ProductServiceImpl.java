package com.cg.dealsdateproductmicroservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dealsdateproductmicroservice.dao.ProductDao;
import com.cg.dealsdateproductmicroservice.entity.ProductCategory;
import com.cg.dealsdateproductmicroservice.entity.ProductEntity;
import com.cg.dealsdateproductmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateproductmicroservice.model.ProductModel;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao repo;

	// converting model to entity
	public ProductEntity of(ProductModel source) {
		ProductEntity result = null;
		if (source != null) {
			result = new ProductEntity();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductPrice(source.getProductPrice());
			result.setProductCategory(source.getProductCategory());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductColor(source.getProductColor());
			result.setImageUrl(source.getImageUrl());

		}
		return result;
	}

	// converting entity to model
	public ProductModel of(ProductEntity source) {
		ProductModel result = null;
		if (source != null) {
			result = new ProductModel();
			result.setProductId(source.getProductId());
			result.setProductName(source.getProductName());
			result.setProductPrice(source.getProductPrice());
			result.setProductCategory(source.getProductCategory());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductColor(source.getProductColor());
			result.setImageUrl(source.getImageUrl());
		}
		return result;
	}

	/************************************************************************************
	 * Method: addProduct Description: To add the Products to Database
	 * 
	 * @param existById: check for the productId if already exits
	 * @param save:      saves the product in the database
	 * @returns product: returns the product which is persisted
	 ************************************************************************************/

	// adding products to database
	@Override
	public ProductModel addProduct(ProductEntity product) throws ProductNotFoundException {
		if (product == null) {
			throw new ProductNotFoundException("Product Should not be null");
		}
		if (repo.existsById(product.getProductId())) {

			throw new ProductNotFoundException("This Product already exist !");
		}
		return of(repo.save(product));

	}

	/***********************************************************************************************
	 * Method: showListOfCategories Description: returns list of categories from the
	 * product table
	 * 
	 * @param findListOfCategories: fetches the list of categories
	 * @returns List<String>: returns the list of categories
	 ***********************************************************************************************/

	// display list of categories from the product table
	@Override
	public List<String> showListOfCategories() throws ProductNotFoundException {
		List<String> list = repo.findListOfCategories();
		if (list != null)
			return list;
		else
			throw new ProductNotFoundException("No Categories available");
	}

	/*********************************************************************************************
	 * Method: displayListOfProducts Description: display all products details from
	 * the table
	 * 
	 * @param findAll: fetches complete list of products
	 * @returns List<ProductModel>: returns the list of products
	 *********************************************************************************************/

	// display all products details from the table
	@Override
	public List<ProductModel> displayListOfProducts() {
		return repo.findAll().stream().map((entity) -> of(entity)).collect(Collectors.toList());
	}

	/***********************************************************************************************************
	 * Method: displayListOfProductByCategory Description: display list of specific
	 * products based on choosed categories
	 * 
	 * @param findListofProductsByCategories: fetches list of products based on
	 *                                        Specific Category
	 * @returns List<ProductModel>: returns the list of products
	 *************************************************************************************************************/

	// display list of specific products based on choosed categories
	@Override
	public List<ProductModel> displayListOfProductByCategory(ProductCategory category) throws ProductNotFoundException {
		if (category == null) {
			throw new ProductNotFoundException("Product Category should not be null");
		}
		if (repo.existsProductByProductCategory(category)) {
			return repo.findListofProductsByCategories(category).stream().map((entity) -> of(entity))
					.collect(Collectors.toList());
		} else
			throw new ProductNotFoundException("Such Category does not exist");

	}

	/**************************************************************************************************************
	 * Method: getListOfProductsOntheBasisOfProductPriceSortingAsc Description:
	 * display list of sorted products in ascending order of prices
	 * 
	 * @param findByOrderByProductPriceAsc: fetches list of products based on sorted
	 *                                      price
	 * @returns List<ProductModel>: returns the list of products
	 ***************************************************************************************************************/

	// display list of sorted products in ascending order of prices
	@Override
	public List<ProductModel> getListOfProductsOntheBasisOfProductPriceSortingAsc() {
		return repo.findByOrderByProductPriceAsc().stream().map((entity) -> of(entity)).collect(Collectors.toList());
	}

	/*************************************************************************************************************
	 * Method: getListOfProductsOntheBasisOfProductPriceSortingDesc Description:
	 * display list of sorted products in descending order of prices
	 * 
	 * @param findByOrderByProductPriceDesc: fetches list of products based on
	 *                                       sorted price
	 * @returns List<ProductModel>: returns the list of products
	 ***************************************************************************************************************/

	// display list of sorted products in descending order of prices
	@Override
	public List<ProductModel> getListOfProductsOntheBasisOfProductPriceSortingDesc() {
		return repo.findByOrderByProductPriceDesc().stream().map((entity) -> of(entity)).collect(Collectors.toList());
	}

	/**********************************************************************************************************************
	 * Method:
	 * getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder
	 * Description: shows products from low to high in specific category
	 * 
	 * @param findByProductCategoryOrderByProductPriceAsc: fetches list of products
	 *                                                     based on sorted price of
	 *                                                     specific category
	 * @returns List<ProductModel>: returns the list of products
	 ***********************************************************************************************************************/
	// shows products from low to high in specific category
	@Override
	public List<ProductModel> getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder(
			ProductCategory category) throws ProductNotFoundException {
		if (category == null) {
			throw new ProductNotFoundException("Product Category should not be null");
		}
		if (repo.existsProductByProductCategory(category)) {
			return repo.findByProductCategoryOrderByProductPriceAsc(category).stream().map((entity) -> of(entity))
					.collect(Collectors.toList());
		} else
			throw new ProductNotFoundException("Such Category does not exist");
	}

	/**********************************************************************************************************************
	 * Method:
	 * getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder
	 * Description: shows products from high to low in specific category
	 * 
	 * @param findByProductCategoryOrderByProductPriceDesc: fetches list of products
	 *                                                      based on sorted price of
	 *                                                      specific category
	 * @returns List<ProductModel>: returns the list of products
	 ***********************************************************************************************************************/
	// shows products from high to low in specific category
	@Override
	public List<ProductModel> getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder(
			ProductCategory category) throws ProductNotFoundException {
		if (category == null) {
			throw new ProductNotFoundException("Product Category should not be null");
		}
		if (repo.existsProductByProductCategory(category)) {
			return repo.findByProductCategoryOrderByProductPriceDesc(category).stream().map((entity) -> of(entity))
					.collect(Collectors.toList());
		} else
			throw new ProductNotFoundException("Such Category does not exist");
	}

	/**********************************************************************************************************************
	 * Method: getProductById Description: returns specific product by Id
	 * 
	 * @param findById: fetches products based on productid
	 * @returns Product returns products
	 ***********************************************************************************************************************/
	// returns specific product by Id
	@Override
	public ProductModel getProductById(Integer id) throws ProductNotFoundException {
		if (id == null) {
			throw new ProductNotFoundException("Product id should not be null");
		} else {
			Optional<ProductEntity> entity = repo.findById(id);
			return entity.isPresent() ? of(entity.get()) : null;
		}
	}

	/**********************************************************************************************************************
	 * Method: deleteProduct Description: deleting a product by Id
	 * 
	 * @param findById: fetches products based on particular productId
	 * @param delete:   deletes products based on particular product Id
	 ***********************************************************************************************************************/
	// deleting a product
	@Override
	public boolean deleteProduct(Integer id) throws ProductNotFoundException {
		boolean flag = false;
		if (id == null) {
			throw new ProductNotFoundException("Product id should not be null");
		}
		if (repo.findById(id) == null) {
			throw new ProductNotFoundException("Product does not exist !");
		} else {
			repo.deleteById(id);
			flag = true;
		}
		return flag;
	}

}
