/**
 * 
 */
package com.seiryo.service;

import java.io.Serializable;
import java.util.List;

import com.seiryo.entity.OrderDetail;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public interface OrderDetailService {
	void save(OrderDetail orderDetail);
	List<OrderDetail> queryOrderDetailByOrderId(String orderId);
	List<OrderDetail> queryAllOrderDetail();
	OrderDetail get(Serializable orderId);
	void delete(OrderDetail orderDetail);
	void update(OrderDetail orderDetail);
}
