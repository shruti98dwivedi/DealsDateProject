package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import com.cg.dealsdateonlinegiftshopping.entity.WishList;
import com.cg.dealsdateonlinegiftshopping.exception.WishListException;

public interface WishListIntf {

	

	public boolean addToWishList(int id) throws WishListException;
	
	public boolean removeFromWishList(int id) throws WishListException;

	public List<WishList> getWishList() throws WishListException;
}
