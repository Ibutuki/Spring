package com.seiryo.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.util.BaseAction;

public class CarAction extends BaseAction<OrderDetail>{
	private static final AtomicInteger counter = new AtomicInteger(1);
	public String buy() {
		String[] shopIdArray = (String[]) getParameters().get("shopId");
		String[] quantityArray = (String[]) getParameters().get("quantity");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = dateFormat.format(new Date());
        Object oCount =  getSession().get("orderCount");
        int orderCount  = 0;
        if (oCount == null) {
        	// 生成订单号
            orderCount = counter.getAndIncrement(); // 获取当前订单计数并自增
		}else{
			orderCount = (Integer) oCount+1;
		}
        getSession().put("orderCount",orderCount);
        String orderId = String.format("%s%06d", dateStr, orderCount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Order order = new Order();
        order.setOrderId(orderId);
        order.setState(0);
        order.setCreateDtm(timestamp);
        getOrderServiceImp().save(order);
        for (int i = 0; i < quantityArray.length; i++) {
        	OrderDetail orderDetail = new OrderDetail();
        	orderDetail.setOrder(order);
        	orderDetail.setOrderId(orderId);
        	orderDetail.setShopId(shopIdArray[i]);
        	orderDetail.setQuantity(Integer.parseInt(quantityArray[i]));
            getOrderDetailServiceImp().save(orderDetail);
		}
        getRequest().put("orderId", orderId);
        getRequest().put("timestamp", timestamp);
        return "success";
	}
	
	public String deleteById() {
		String[] index = (String[]) getParameters().get("id");
		int i = -1;
		if(index != null) {
			i = Integer.parseInt(index[0]);
		}
		List<OrderDetail> tempDetailList = (List<OrderDetail>) getSession().get("tempDetailList");
		tempDetailList.remove(i);
		getSession().put("tempDetailList", tempDetailList);
		return "car";
	}
	public String clearCar() {
//		session.invalidate();
		getSession().clear();
		return showInite();
	}
	public String showInite() {
		List<OrderDetail> tempDetailList = (List<OrderDetail>) getSession().get("tempDetailList");
		if(tempDetailList == null){
			tempDetailList = new ArrayList<OrderDetail>();
		}
		return "car";
	}
}
