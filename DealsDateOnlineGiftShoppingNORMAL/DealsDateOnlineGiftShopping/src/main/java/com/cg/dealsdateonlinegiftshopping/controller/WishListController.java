package com.cg.dealsdateonlinegiftshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dealsdateonlinegiftshopping.entity.WishList;
import com.cg.dealsdateonlinegiftshopping.service.WishListIntf;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:4200/")
public class WishListController {

	@Autowired
	private WishListIntf wishListService;
	
	@PostMapping("/addtowishlist/{id}")
	public ResponseEntity<String> addToWishList(@PathVariable int id)
	{
		boolean status = wishListService.addToWishList(id);
		if(status == true)
		{
			return new ResponseEntity<String>("Sucessfully Added",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed To Add",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/removefromwishlist/{id}")	
	public ResponseEntity<String> removeFromWishList(@PathVariable int id)
	{
		boolean status = wishListService.removeFromWishList(id);
		if(status == true)
		{
			return new ResponseEntity<String>("Sucessfully Removed",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed To Remove",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getwishlist")
	public ResponseEntity<List<WishList>> getWishList()
	{
		List<WishList> list = wishListService.getWishList();
		return new ResponseEntity<List<WishList>>(list,HttpStatus.OK);	
	}
}
