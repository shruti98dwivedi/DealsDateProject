package com.cg.dealsdateonlinegiftshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateonlinegiftshopping.entity.WishList;

@Repository
public interface WishListDao extends JpaRepository<WishList,Integer> {

}
