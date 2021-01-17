package com.cg.dealsdateonlinegiftshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateonlinegiftshopping.entity.CartItem;

@Repository
public interface CartItemDao extends JpaRepository<CartItem,Integer>{

}
