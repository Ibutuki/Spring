 /**
 * 
 */
package com.seiryo.dao.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.seiryo.dao.OrderDao;
import com.seiryo.entity.Order;
import com.seiryo.util.BaseDaoImp;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao.imp
 * @file_name    OrderDaoImp.java
 * @classname    OrderDaoImp
 * @version      
 */
@Repository
public class OrderDaoImp extends BaseDaoImp<Order> implements OrderDao{

	@Override
	public void deleteAll() {
		  String hql = "delete from Order";
	      this.getHibernateTemplate().bulkUpdate(hql);
	}

	@Override
	public Order queryOrderByOrderId(String orderId) {
		List<Order> list =  this.getHibernateTemplate().find("from Order where orderId = ?",orderId);
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
}
