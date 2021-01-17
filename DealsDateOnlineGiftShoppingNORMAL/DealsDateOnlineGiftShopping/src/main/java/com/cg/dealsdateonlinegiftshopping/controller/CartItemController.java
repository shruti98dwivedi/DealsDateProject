package com.cg.dealsdateonlinegiftshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dealsdateonlinegiftshopping.entity.CartItem;
import com.cg.dealsdateonlinegiftshopping.exception.CartItemException;
import com.cg.dealsdateonlinegiftshopping.service.CartItemServiceImpl;

@RestController
@RequestMapping("/cartitems")
@CrossOrigin(origins="http://localhost:4200")
public class CartItemController {

	@Autowired
	private CartItemServiceImpl cartItemService;
	
	@PostMapping("/addtocartitems/{productId}")
	public ResponseEntity<String> addToCart(@PathVariable int productId){
		String message=cartItemService.addToCartItem(productId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	
	/*@PostMapping("/proceedtocheckout")
	public ResponseEntity<String> confirmItem(@RequestBody CartItem cartItem, BindingResult br)throws CartItemException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CartItemException(err);
		}
		
		
		try {
			cartItemService.confirmItem(cartItem);
			return new ResponseEntity<String>("Item Confirmed For Checkout Successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new CartItemException("ID already exists");
		}
	}*/

	
	@GetMapping("/viewcartitem")
	public ResponseEntity<List<CartItem>> getCartItemlist() {
		List<CartItem> cartItemList = cartItemService.show();
		return new ResponseEntity<List<CartItem>>(cartItemList, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletecartitem/{cartItemId}")
	public ResponseEntity<String> deletecartItem( @PathVariable Integer cartItemId) throws CartItemException
	{
		try
		{
			cartItemService.deleteItem( cartItemId);
			return new ResponseEntity<String>("Item is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new CartItemException("CartItem ID  doesnot exists");
		}
	}
	
	
}
