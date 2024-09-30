package com.seiryo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONException;

import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.util.BaseAction;
import com.seiryo.util.JSONUtil;

public class OrderAction extends BaseAction<Order>{
	private double totalAmount;
	List<OrderDetail> orderDetails;
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public String inite () {
		List<Order> orderList = getOrderServiceImp().query();
		getRequest().put("orderList", orderList);
		return "admin";
	}
	public String showTable2() {
		String orderId = (String) getRequest().get("orderId");
		orderDetails = getOrderDetailServiceImp().queryOrderDetailByOrderId(orderId);
        totalAmount = 0;
        for (OrderDetail detail : orderDetails) {
            totalAmount += detail.getTotalPrice();
        }
        return inite();
	}

	public String updateState() {
		String[] orderId = (String[]) getParameters().get("orderId");
		Order tepOrder = null;
		if(orderId != null) {
			tepOrder = getOrderServiceImp().queryOrderByOrderId(orderId[0]);
		}
		String[] state = (String[]) getParameters().get("state");
		Integer id = tepOrder.getID();
		if(state != null) {
			Order order = tepOrder;
			order.setID(id);
			order.setState(Integer.parseInt(state[0]));
			getOrderServiceImp().update(order);
		}
		return inite();
	}
}
