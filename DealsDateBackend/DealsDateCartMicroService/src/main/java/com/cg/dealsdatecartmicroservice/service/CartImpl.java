package com.cg.dealsdatecartmicroservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdatecartmicroservice.dao.CartDao;
import com.cg.dealsdatecartmicroservice.entity.Cart;
import com.cg.dealsdatecartmicroservice.exception.CartException;
import com.cg.dealsdatecartmicroservice.model.CartModel;
import com.cg.dealsdatecartmicroservice.model.ProductModel;


@Service
public class CartImpl implements CartIntf {

	@Autowired
	private CartDao cartRepo;

	@Autowired
	private ProductProxyService productProxyService;

	public Cart of(CartModel source) {
		Cart result = null;
		if (source != null) {
			result = new Cart();
			result.setCartId(source.getCartId());
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());
			result.setProductName(source.getProductName());
			result.setProductQuantity(source.getProductQuantity());
			result.setProductPrice(source.getProductPrice());
			result.setProductColor(source.getProductColor());
			result.setProductSpecification(source.getProductSpecification());
			result.setProductCategory(source.getProductCategory());
			result.setImageUrl(source.getImageUrl());
		}
		return result;
	}

	public CartModel of(Cart source) {
		CartModel result = null;
		if (source != null) {
			result = new CartModel();
			result.setCartId(source.getCartId());
			result.setProductId(source.getProductId());
			result.setUserId(source.getUserId());

			ProductModel product = productProxyService.getProduct(source.getProductId());
			if (product != null) {
				result.setProductName(product.getProductName());
				result.setProductPrice(product.getProductPrice());
				result.setProductCategory(product.getProductCategory());
				result.setImageUrl(product.getImageUrl());
				result.setProductSpecification(product.getProductSpecification());
				result.setProductQuantity(product.getProductQuantity());
				result.setProductColor(product.getProductColor());
			}
		}
		return result;
	}
	
	/************************************************************************************
	 * Method: addToCart Description: To add the Products to Cart Database
	 * @param existById: check for the productId if already exits
	 * @param save:      saves the product in the database
	 * @returns product: returns the product which is persisted
	 ************************************************************************************/

	@Override
	public CartModel addToCart(Cart cart) throws CartException {
		if (cart == null) {
			throw new CartException("Cart Should not be null");
		}
		if (cartRepo.existsById(cart.getProductId())) {
			throw new CartException("Prdouct id already exists !");
		} 
		else {
			 return of(cartRepo.save((cart)));
		}
	}
	
	/**********************************************************************************************************************
	 * Method: removeFromCart Description: deleting a product by Id
	 * @param findById: fetches products based on particular productId
	 * @param delete:   deletes products based on particular product Id
	 ***********************************************************************************************************************/
	
	@Override
	public boolean removeFromCart(int id) throws CartException {
		boolean flag=false;
		if(!cartRepo.existsById(id)) {
			throw new CartException("Failed to remove product");
		}
		else {
			cartRepo.deleteById(id);
			flag=true;
		}
		return flag;
	}
	
	/*********************************************************************************************
	 * Method: getCart Description: display all products details from
	 *         Cart table
	 * @param findAll: fetches complete list of products
	 * @returns List<Wishlist>: returns the list of products
	 *********************************************************************************************/

	@Override
	public List<Cart> getCart() throws CartException {
		List<Cart> list = cartRepo.findAll();
		if (list == null) {
			throw new CartException("List Is Empty");
		}
		return list;
	}
	
}