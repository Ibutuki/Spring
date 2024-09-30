/**
 * 
 */
package com.seiryo.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seiryo.dao.OrderDetailDao;
import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.entity.ShopInfo;
import com.seiryo.util.BaseDaoImp;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao.imp
 * @file_name    OrderDetailDaoImp.java
 * @classname    OrderDetailDaoImp
 * @version      
 */
@Repository
public class OrderDetailDaoImp extends BaseDaoImp<OrderDetail> implements OrderDetailDao{
//	多表联查
	@Autowired
	 private SessionFactory sessionFactory;
	@Override
	public List<OrderDetail> queryAllOrderDetail() {
		String sql = "SELECT "
				+ "tb_orderDetail.orderId,"
				+ "tb_orderDetail.shopId,"
				+ "quantity,"
				+ "tb_shopInfo.shopName,"
				+ "tb_shopInfo.price,"
				+ "tb_shopInfo.price*tb_orderDetail.quantity,"
				+ "createDtm,"
				+ "state"
				+" FROM tb_orderDetail, tb_shopInfo, tb_order"
				+" where tb_orderDetail.shopId = tb_shopInfo.shopId and tb_order.orderId = tb_orderDetail.orderId";
		SQLQuery  query = sessionFactory.openSession().createSQLQuery(sql);
		List<Object[]> temlist = query.list();
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		for(Object[] obj : temlist) {
			OrderDetail detail = new OrderDetail();
            detail.setOrderId((String)obj[0]);
            detail.setShopId((String) obj[1]);
            detail.setQuantity((Integer) obj[2]);
            detail.setTotalPrice(((Float) obj[5]).doubleValue());
            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setShopName((String) obj[3]);
            shopInfo.setPrice(((Float) obj[4]).doubleValue());
            Order order = new Order();
            order.setCreateDtm(new Date(((Timestamp) obj[6]).getTime()));
            order.setState((Integer) obj[7]);
            detail.setShopInfo(shopInfo);
            list.add(detail);
		}
        return list;
	}
//	多表联查
	@Override
	public List<OrderDetail> queryOrderDetailByOrderId(String orderId) {
		String sql = "SELECT "
				+ "tb_orderDetail.orderId,"
				+ "tb_orderDetail.shopId,"
				+ "quantity,"
				+ "tb_shopInfo.shopName,"
				+ "tb_shopInfo.price,"
				+ "tb_shopInfo.price*tb_orderDetail.quantity,"
				+ "createDtm,"
				+ "state"
				+" FROM tb_orderDetail, tb_shopInfo, tb_order"
				+" where tb_orderDetail.shopId = tb_shopInfo.shopId and tb_order.orderId = tb_orderDetail.orderId"
				+ " and tb_orderDetail.orderId = ?";
		SQLQuery  query = sessionFactory.openSession().createSQLQuery(sql);
		query.setParameter(0, orderId);
		List<Object[]> temlist = query.list();
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		for(Object[] obj : temlist) {
			OrderDetail detail = new OrderDetail();
            detail.setOrderId((String)obj[0]);
            detail.setShopId((String) obj[1]);
            detail.setQuantity((Integer) obj[2]);
            detail.setTotalPrice(((Float) obj[5]).doubleValue());
            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setShopName((String) obj[3]);
            shopInfo.setPrice(((Float) obj[4]).doubleValue());
            Order order = new Order();
            order.setCreateDtm(new Date(((Timestamp) obj[6]).getTime()));
            order.setState((Integer) obj[7]);
            detail.setShopInfo(shopInfo);
            list.add(detail);
		}
        return list;
	}

	
}
