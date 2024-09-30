/**
 * 
 */
package com.seiryo.service.imp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seiryo.dao.OrderDao;
import com.seiryo.dao.imp.OrderDaoImp;
import com.seiryo.entity.Order;
import com.seiryo.service.OrderService;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
@Service
public class OrderServiceImp implements OrderService{
	private OrderDao orderDao;
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Order> query() {
		// TODO Auto-generated method stub
		return orderDao.query();
	}

	@Override
	public Order get(Serializable id) {
		// TODO Auto-generated method stub
		return orderDao.get(id);
	}

	@Override
	public Order queryOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.queryOrderByOrderId(orderId);
	}

	@Override
	public void update(Order order) {
		orderDao.update(order);
		
	}

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		orderDao.delete(order);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		orderDao.deleteAll();
	}
}
