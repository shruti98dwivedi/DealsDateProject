package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateonlinegiftshopping.dao.CartItemDao;
import com.cg.dealsdateonlinegiftshopping.dao.ProductDao;
import com.cg.dealsdateonlinegiftshopping.entity.CartItem;
import com.cg.dealsdateonlinegiftshopping.entity.Product;
import com.cg.dealsdateonlinegiftshopping.exception.WishListException;

@Service
public class CartItemServiceImpl implements CartItemServiceIntf {

	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	
	@Override
	public boolean confirmItem(CartItem cartItem) {
		return true;
	}
	
	
	@Override
	public String deleteItem(Integer cartItemId) {
		if(cartItemDao.existsById(cartItemId)) {
			cartItemDao.deleteById(cartItemId);	
			return "Item Deleted successfully from the cart...!!!";
		}
		else 
			 return "Such Id does not exist..!!";
	
		
	}

	
	
	@Override
	public List<CartItem> show() {
		return cartItemDao.findAll();
	}
	
	

	@Override
	public String addToCartItem(int productId) throws WishListException{
		if(productDao.existsById(productId))
		{
			Optional<Product> list=productDao.findById(productId);
			Product product=list.get();
			CartItem item=new CartItem();
			item.setProductName(product.getProductName());
			item.setProductPrice(product.getProductPrice());
			item.setCartItemQuantity(product.getProductQuantity());	
	   cartItemDao.saveAndFlush(item);
		
		return "Item Added Successfully..!!";
		}
		else
			throw new WishListException("Such Product does not exist");
	}

	

}
