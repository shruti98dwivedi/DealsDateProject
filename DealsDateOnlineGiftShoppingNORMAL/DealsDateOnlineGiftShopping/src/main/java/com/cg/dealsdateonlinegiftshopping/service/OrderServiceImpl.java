package com.cg.dealsdateonlinegiftshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dealsdateonlinegiftshopping.dao.OrderDao;
import com.cg.dealsdateonlinegiftshopping.dao.UserDao;
import com.cg.dealsdateonlinegiftshopping.dao.WishListDao;
import com.cg.dealsdateonlinegiftshopping.entity.Order;

@Service
public class OrderServiceImpl implements OrderServiceIntf {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private WishListDao wishListDao;
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public boolean placeOrder(Order order) {
		return orderDao.save(order) !=null;
	}

	@Override
	public void deleteOrder(Integer orderId) {
		orderDao.deleteById(orderId);
		
	}

	@Override
	public List<Order> show() {
		return orderDao.findAll();
	}

}
	
	
