package com.cg.dealsdateonlinegiftshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dealsdateonlinegiftshopping.entity.Product;
import com.cg.dealsdateonlinegiftshopping.entity.ProductCategory;
import com.cg.dealsdateonlinegiftshopping.entity.WishList;
import com.cg.dealsdateonlinegiftshopping.service.ProductServiceImpl;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {
	 
	@Autowired
	private ProductServiceImpl service;
	
	
	
	//display list of all products
	@GetMapping("/displaylistofproducts")
	public ResponseEntity<List<Product>> getListOfProducts(){
		List<Product> list= service.displayListOfProducts();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	
	
	
	//adding product
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	
	//display list of categories
	@GetMapping("/listofcategories")
	public ResponseEntity<List<String>> fetchListOfCategories(){
		List<String> categoriesList= service.showListOfCategories();
		categoriesList.add(0,"All");
		return new ResponseEntity<List<String>>(categoriesList,HttpStatus.OK);
	}
	
	
	
	//display list of products on the basis of particular category
	@GetMapping("/fetchlistofproductsbycategory/{category}")
	public  ResponseEntity<List<Product>> fetchListOfProductsByCategory(@PathVariable("category") ProductCategory category){
	
		List<Product> list =service.displayListOfProductByCategory(category);
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	
	}
	
	//display list of products on the basis of filtering of price in ascending order
	@GetMapping("/listofsortedproductsasc")
	public ResponseEntity<List<Product>> fetchListOfProdctsOnProductPriceSortingAsc(){
		List<Product> list =service.getListOfProductsOntheBasisOfProductPriceSortingAsc();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	//display list of products on the basis of filtering of price in descending order
		@GetMapping("/listofsortedproductsdesc")
		public ResponseEntity<List<Product>> fetchListOfProdctsOnProductPriceSortingDesc(){
			List<Product> list =service.getListOfProductsOntheBasisOfProductPriceSortingDesc();
			return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		}
}
