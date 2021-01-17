package com.cg.dealsdateonlinegiftshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<Object> handleException(UserException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = WishListException.class)
	public ResponseEntity<Object> handleException(WishListException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = ProductException.class)
	public ResponseEntity<Object> handleException(ProductException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	
	@ExceptionHandler(value = OrderException.class)
	public ResponseEntity<Object> handleException(OrderException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = CartItemException.class)
	public ResponseEntity<Object> handleException(CartItemException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
	}
}


