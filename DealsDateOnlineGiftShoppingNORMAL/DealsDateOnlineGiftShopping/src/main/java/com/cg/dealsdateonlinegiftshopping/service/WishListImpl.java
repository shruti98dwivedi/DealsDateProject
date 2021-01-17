package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateonlinegiftshopping.dao.ProductDao;
import com.cg.dealsdateonlinegiftshopping.dao.WishListDao;
import com.cg.dealsdateonlinegiftshopping.entity.Product;
import com.cg.dealsdateonlinegiftshopping.entity.WishList;
import com.cg.dealsdateonlinegiftshopping.exception.WishListException;

@Service
public class WishListImpl implements WishListIntf {

	@Autowired
	ProductDao productRepo;
	@Autowired
	private WishListDao wishListRepo;
	
	
	@Override
	public boolean addToWishList(int id) throws WishListException {
		if(productRepo.existsById(id))
		{
			Optional<Product> temppro = productRepo.findById(id);
			Product product = temppro.get();
			WishList wishList = new WishList();
			wishList.setProductId(product.getProductId());
			wishList.setProductName(product.getProductName());
			wishList.setPrice(product.getProductPrice());
			wishList.setProductCategory(product.getProductCategory());
			wishList.setProductDescription(product.getProductSpecification());
			// lemme run it first 
			wishList.setUserId(11608248);
			wishListRepo.saveAndFlush(wishList);
			return true;
		}
		else
		{
			throw new WishListException("Failed to add product");
		}
	}

	@Override
	public boolean removeFromWishList(int id) throws WishListException {
		if(wishListRepo.findById(id) == null)
		{
			throw new WishListException("Failed to remove product");
		}
		wishListRepo.deleteById(id);
		return true;
	}

	@Override
	public List<WishList> getWishList() throws WishListException {
		List<WishList> list = wishListRepo.findAll();
		if(list == null)
		{
			throw new WishListException("List Is Empty");
		}
		return list;
	}
	}


