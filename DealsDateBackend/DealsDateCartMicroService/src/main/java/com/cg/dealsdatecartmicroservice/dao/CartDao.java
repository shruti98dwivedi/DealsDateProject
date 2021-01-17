package com.cg.dealsdatecartmicroservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dealsdatecartmicroservice.entity.Cart;



@Repository
public interface CartDao extends JpaRepository<Cart,Integer> {
	
}
