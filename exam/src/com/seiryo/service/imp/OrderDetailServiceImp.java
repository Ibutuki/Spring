/**
 * 
 */
package com.seiryo.service.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seiryo.dao.OrderDetailDao;
import com.seiryo.dao.imp.OrderDetailDaoImp;
import com.seiryo.entity.OrderDetail;
import com.seiryo.service.OrderDetailService;

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
public class OrderDetailServiceImp implements OrderDetailService{
	private OrderDetailDao orderDetailDao;
	@Autowired
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}

	

	@Override
	public List<OrderDetail> queryOrderDetailByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDetailDao.queryOrderDetailByOrderId(orderId);
	}

	@Override
	public List<OrderDetail> queryAllOrderDetail() {
		// TODO Auto-generated method stub
		return orderDetailDao.queryAllOrderDetail();
	}

	@Override
	public OrderDetail get(Serializable orderId) {
		// TODO Auto-generated method stub
		return orderDetailDao.get(orderId);
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.delete(orderDetail);
	}

	@Override
	public void update(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.update(orderDetail);
	}

}
