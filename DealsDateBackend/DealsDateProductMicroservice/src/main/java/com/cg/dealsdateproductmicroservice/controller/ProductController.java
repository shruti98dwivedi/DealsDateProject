package com.cg.dealsdateproductmicroservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dealsdateproductmicroservice.entity.ProductCategory;
import com.cg.dealsdateproductmicroservice.entity.ProductEntity;
import com.cg.dealsdateproductmicroservice.exception.ProductNotFoundException;
import com.cg.dealsdateproductmicroservice.model.ProductModel;
import com.cg.dealsdateproductmicroservice.service.ProductServiceImpl;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductServiceImpl service;

	// display list of all products
	@GetMapping("/listofproducts")
	public ResponseEntity<List<ProductModel>> getListOfProducts() {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> product = service.displayListOfProducts();
		if (product == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return response;

	}

	/************************************************************************************
	 * Method: addProduct Description: To add the Products to Database
	 * 
	 * @param addProduct: saves the product in the database
	 * @returns product: returns the response entity of product which is persisted
	 ************************************************************************************/

	// adding product
	@PostMapping
	public ResponseEntity<ProductModel> addProduct(@RequestBody ProductEntity product) throws ProductNotFoundException {
		return new ResponseEntity<>(service.addProduct(product), HttpStatus.OK);
	}

	/**********************************************************************************************************************
	 * Method: deleteProduct Description: deleting a product by Id
	 * 
	 * @param deleteProduct: deletes products based on particular product Id
	 * @returns product: returns the boolean response entity
	 ***********************************************************************************************************************/
	// deleting a product
	@DeleteMapping("/deleteproducts/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable(value = "id") Integer id)
			throws ProductNotFoundException {
		boolean value = service.deleteProduct(id);
		if (value == true)
			return ResponseEntity.ok(true);
		else
			return ResponseEntity.ok(false);
	}

	/**********************************************************************************************************************
	 * Method: fetchListOfCategories Description: display list of categories
	 * 
	 * @param showListOfCategories: fectches list of categories
	 * @returns List<String>: returns response entity of list of Strings of
	 *          categories
	 ***********************************************************************************************************************/

	// display list of categories
	@GetMapping("/listofcategories")
	public ResponseEntity<List<String>> fetchListOfCategories() throws ProductNotFoundException {
		List<String> categoriesList = service.showListOfCategories();
		categoriesList.add(0, "All");
		return new ResponseEntity<List<String>>(categoriesList, HttpStatus.OK);
	}

	/**********************************************************************************************************************
	 * Method: fetchListOfProductsByCategory Description display list of products on
	 * the basis of particular category
	 * 
	 * @param displayListOfProductByCategory: fetches list of products based on
	 *                                        category
	 * @returns List<ProductModel>: returns response entity of list of Products
	 ***********************************************************************************************************************/

	// display list of products on the basis of particular category
	@GetMapping("/listofspecificproducts/{category}")
	public ResponseEntity<List<ProductModel>> fetchListOfProductsByCategory(
			@PathVariable("category") ProductCategory category) throws ProductNotFoundException {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> list = service.displayListOfProductByCategory(category);
		if (list == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return response;

	}

	/**********************************************************************************************************************
	 * Method: fetchListOfProdctsOnProductPriceSortingAsc Description: display list
	 * of products on the basis of filtering of price in ascending order
	 * 
	 * @param getListOfProductsOntheBasisOfProductPriceSortingAsc: fetches list of
	 *                                                             products based on
	 *                                                             sorting
	 * @returns List<ProductModel>: returns response entity of list of Products
	 ***********************************************************************************************************************/
	// display list of products on the basis of filtering of price in ascending
	// order
	@GetMapping("/listofproductsinasc")
	public ResponseEntity<List<ProductModel>> fetchListOfProdctsOnProductPriceSortingAsc() {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> list = service.getListOfProductsOntheBasisOfProductPriceSortingAsc();
		if (list == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return response;
	}

	/**********************************************************************************************************************
	 * Method: fetchListOfProdctsOnProductPriceSortingDesc Description: display list
	 * of products on the basis of filtering of price in descending order
	 * 
	 * @param getListOfProductsOntheBasisOfProductPriceSortingDesc: fectches list of
	 *                                                              products based
	 *                                                              on sorting
	 * @returns List<ProductModel>: returns response entity of list of Products
	 ***********************************************************************************************************************/
	// display list of products on the basis of filtering of price in descending
	// order
	@GetMapping("/listofproductsindesc")
	public ResponseEntity<List<ProductModel>> fetchListOfProdctsOnProductPriceSortingDesc() {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> list = service.getListOfProductsOntheBasisOfProductPriceSortingDesc();
		if (list == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return response;
	}

	/**********************************************************************************************************************
	 * Method: fetchListOfProductsOnProductPriceSortingAscCategoryWise Description:
	 * display list of sorted products of specific category ascending order
	 * 
	 * @param getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder: fectches
	 *                                                                                  list
	 *                                                                                  of
	 *                                                                                  products
	 *                                                                                  based
	 *                                                                                  on
	 *                                                                                  sorting
	 *                                                                                  in
	 *                                                                                  specific
	 *                                                                                  category
	 * @returns List<ProductModel>: returns response entity of list of Products
	 ***********************************************************************************************************************/
	// display list of sorted products of specific category ascending order
	@GetMapping("/listofproductscategorywisesorting/{category}")
	public ResponseEntity<List<ProductModel>> fetchListOfProductsOnProductPriceSortingAscCategoryWise(
			@PathVariable("category") ProductCategory category) throws ProductNotFoundException {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> list = service
				.getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInAscOrder(category);
		if (list == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return response;
	}

	/**********************************************************************************************************************
	 * Method: fetchListOfProductsOnProductPriceSortingDescCategoryWise Description:
	 * display list of sorted products of specific category in descending order
	 * 
	 * @param getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder: fetches
	 *                                                                                   list
	 *                                                                                   of
	 *                                                                                   products
	 *                                                                                   based
	 *                                                                                   on
	 *                                                                                   specific
	 *                                                                                   category
	 *                                                                                   sorted
	 *                                                                                   by
	 *                                                                                   price
	 * @returns List<ProductModel>: returns response entity of Product
	 ***********************************************************************************************************************/

	// display list of sorted products of specific category in descending order
	@GetMapping("/listofproductscategorywisesortingdesc/{category}")
	public ResponseEntity<List<ProductModel>> fetchListOfProductsOnProductPriceSortingDescCategoryWise(
			@PathVariable("category") ProductCategory category) throws ProductNotFoundException {
		ResponseEntity<List<ProductModel>> response = null;
		List<ProductModel> list = service
				.getListOfProductsOnTheBasisOfProductPriceSortingByCategorywiseInDescOrder(category);
		if (list == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(list, HttpStatus.OK);
		}
		return response;
	}

	/**********************************************************************************************************************
	 * Method: getProductById Description: return specific productId
	 * 
	 * @param getProductById: fectches produc based on particular id
	 * @returns ProductModel: returns response entity of Product
	 ***********************************************************************************************************************/
	// return specific productId
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<ProductModel> getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {

		ResponseEntity<ProductModel> response = null;
		ProductModel product = service.getProductById(id);
		if (product == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		}
		return response;

	}

}
