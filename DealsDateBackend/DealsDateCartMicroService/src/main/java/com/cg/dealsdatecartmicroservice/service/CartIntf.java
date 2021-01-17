package com.cg.dealsdatecartmicroservice.service;

import java.util.List;
import com.cg.dealsdatecartmicroservice.entity.Cart;
import com.cg.dealsdatecartmicroservice.exception.CartException;
import com.cg.dealsdatecartmicroservice.model.CartModel;


public interface CartIntf{
	
	public CartModel addToCart(Cart model) throws CartException;
	
	public boolean removeFromCart(int id) throws CartException;

	public List<Cart> getCart() throws CartException;
	
	
	
}