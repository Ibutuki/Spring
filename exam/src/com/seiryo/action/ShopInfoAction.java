package com.seiryo.action;

import java.util.ArrayList;
import java.util.List;

import com.seiryo.entity.Order;
import com.seiryo.entity.OrderDetail;
import com.seiryo.entity.ShopInfo;
import com.seiryo.util.BaseAction;

public class ShopInfoAction extends BaseAction<ShopInfo> {
	//加入购物车临时session
	public String intoCar() {
		String[] id = (String[]) getParameters().get("id");
		ShopInfo shopInfo = getShopInfoServiceImp().get(Integer.parseInt(id[0]));
		List<OrderDetail> tempDetailList = (List<OrderDetail>) getSession().get("tempDetailList");
		if(tempDetailList == null){
			tempDetailList = new ArrayList<OrderDetail>();
		}
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setShopId(shopInfo.getShopId());
		orderDetail.setQuantity(1);
		orderDetail.setTotalPrice(shopInfo.getPrice());
		orderDetail.setShopInfo(shopInfo);
		tempDetailList.add(orderDetail);
		getSession().put("tempDetailList", tempDetailList);
		return "car";
	}
	public String queryOrderState() {
		String[] orderIds = (String[]) getParameters().get("orderId");
	    String orderId = (orderIds != null && orderIds.length > 0) ? orderIds[0] : null;
		Order order = getOrderServiceImp().queryOrderByOrderId(orderId);
		if(order == null){
			getRequest().put("state",  "无对应订单");
			return index();
		}
		int state = order.getState();
		String out = "";
		if(state == 0){
			out = "待审核 "; 
		}else if(state == 1){
			out = "已审核 ";
		}else if(state == 2){
			out = "已付款";
		}else if(state == 3){
			out = "已发货";
		}
		getRequest().put("state", out);
		return index();
	}
	public String queryShop() {
		String shopName = getModel().getShopName();
		String descr = getModel().getDescr();
		List<ShopInfo> shopInfoList = getShopInfoServiceImp().queryShopInfoByNameAndDescr(shopName, descr);
		getRequest().put("shopInfoList", shopInfoList);
		return "shop";
	}
	public String index() {
		List<ShopInfo> shopInfoList = getShopInfoServiceImp().query();
		getRequest().put("shopInfoList", shopInfoList);
		return "shop";
	}
	
}
