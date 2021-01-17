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

import com.cg.dealsdateonlinegiftshopping.entity.Order;
import com.cg.dealsdateonlinegiftshopping.exception.OrderException;
import com.cg.dealsdateonlinegiftshopping.service.OrderServiceImpl;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins="http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderService;
	
	
	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder( @RequestBody Order order, BindingResult br)
			throws OrderException {
		String err = "";
		if (br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for (FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new OrderException(err);
		}
		try {
			orderService.placeOrder(order);
			return new ResponseEntity<String>("Order Placed Successfully", HttpStatus.OK);

		} catch (DataIntegrityViolationException ex) {
			throw new OrderException("Order already exists");
		}
	}

	
	@GetMapping("/vieworder")
	public ResponseEntity<List<Order>> getOrderlist() {
		List<Order> orderList = orderService.show();
		return new ResponseEntity<List<Order>>(orderList, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteorder/{orderId}")
	public ResponseEntity<String> deleteorder( @PathVariable Integer orderId) throws OrderException
	{
		try
		{
			orderService.deleteOrder( orderId);
			return new ResponseEntity<String>("Order is deleted", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new OrderException("Order ID  doesnot exists");
		}
	}
	

}
