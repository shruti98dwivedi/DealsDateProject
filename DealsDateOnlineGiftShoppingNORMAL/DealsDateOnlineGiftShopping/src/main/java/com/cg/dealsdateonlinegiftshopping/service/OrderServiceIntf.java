package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import com.cg.dealsdateonlinegiftshopping.entity.Order;

public interface OrderServiceIntf {

	
	boolean placeOrder(Order order);
	void  deleteOrder(Integer orderId);
	List<Order> show();
	 
}
