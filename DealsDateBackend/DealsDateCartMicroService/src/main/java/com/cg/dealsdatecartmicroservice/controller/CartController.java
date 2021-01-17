package com.cg.dealsdatecartmicroservice.controller;
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
import com.cg.dealsdatecartmicroservice.entity.Cart;
import com.cg.dealsdatecartmicroservice.model.CartModel;
import com.cg.dealsdatecartmicroservice.service.CartIntf;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

	@Autowired
	private CartIntf cartService;
	
	/************************************************************************************
	 * Method: addToCart Description: To add the Products to Cart Database
	 * @param addToCart: add the product in the Cart database
	 * @returns product: returns the response entity of string with a message
	 ************************************************************************************/
	
	@PostMapping("/addtocart")
	public ResponseEntity<String> addToCart(@RequestBody Cart  cartModel)
	{
	  CartModel model = cartService.addToCart(cartModel);
		if(model!= null)
		{
			return new ResponseEntity<String>("Sucessfully Added",HttpStatus.OK);
		}
		return new ResponseEntity<String>("already added to the cart",HttpStatus.ALREADY_REPORTED);
	}
	
	/**********************************************************************************************************************
	 * Method: removeFromCart Description: deleting a product by Id
	 * @param removeFromCart: deletes products based on particular product Id
	 * @returns product: returns the string response entity
	 ***********************************************************************************************************************/
	
	@DeleteMapping("/removefromcart/{id}")	
	public ResponseEntity<String> removeFromCart(@PathVariable int id)
	{
		boolean status = cartService.removeFromCart(id);
		if(status == true)
		{
			return new ResponseEntity<String>("Sucessfully Removed",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed To Remove",HttpStatus.NOT_FOUND);
	}
	
	/**********************************************************************************************************************
	 * Method: getCart Description: Fetches all the products present in the DB
	 * @param getCart: Fetches all products
	 * @returns product: returns the List<Cart> response entity
	 ***********************************************************************************************************************/
	
	
	@GetMapping("/getcart")
	public ResponseEntity<List<Cart>> getCart()
	{
		ResponseEntity<List<Cart>> response = null;
		List<Cart> cart = cartService.getCart();
		if (cart == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(cart,HttpStatus.OK);
		}
		return response;
	}
}