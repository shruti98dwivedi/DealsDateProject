package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import com.cg.dealsdateonlinegiftshopping.entity.CartItem;
import com.cg.dealsdateonlinegiftshopping.exception.WishListException;

public interface CartItemServiceIntf {

	
	boolean confirmItem(CartItem cartItem);
	String  deleteItem(Integer cartItemId);
	List<CartItem> show();
    String addToCartItem(int productId) throws WishListException;
	 
	
}
