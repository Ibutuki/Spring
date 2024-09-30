/**
 * 
 */
package com.seiryo.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.seiryo.entity.Order;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    OrderDao.java
 * @classname    OrderDao
 * @version      
 */
public interface OrderDao {
	//��ѯ
	List<Order> query();
	Order get(Serializable id);
	Order queryOrderByOrderId(String orderId);
	void update(Order order);
	//����
	void save(Order order);
	//ɾ��
	void delete(Order order);
	void deleteAll();
}
