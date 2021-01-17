package com.cg.dealsdateonlinegiftshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateonlinegiftshopping.entity.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

}
