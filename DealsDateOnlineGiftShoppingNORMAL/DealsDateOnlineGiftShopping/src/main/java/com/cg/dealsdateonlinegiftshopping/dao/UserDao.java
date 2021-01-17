package com.cg.dealsdateonlinegiftshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dealsdateonlinegiftshopping.entity.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{

}
