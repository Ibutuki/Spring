package com.seiryo.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.seiryo.entity.ShopInfo;
import com.seiryo.service.OrderDetailService;
import com.seiryo.service.OrderService;
import com.seiryo.service.ShopInfoService;
import com.seiryo.service.UserService;


public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private T t;
	public BaseAction() {
		try {
			ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	@Override
	public T getModel() {
		return t;
	}
	// 注入需要使用的service，提供get、set方法
	OrderService orderServiceImp;
	OrderDetailService orderDetailServiceImp;
	ShopInfoService shopInfoServiceImp;
	UserService userServiceImp;
	
	public OrderService getOrderServiceImp() {
		return orderServiceImp;
	}
	public void setOrderServiceImp(OrderService orderServiceImp) {
		this.orderServiceImp = orderServiceImp;
	}
	public OrderDetailService getOrderDetailServiceImp() {
		return orderDetailServiceImp;
	}
	public void setOrderDetailServiceImp(OrderDetailService orderDetailServiceImp) {
		this.orderDetailServiceImp = orderDetailServiceImp;
	}
	public ShopInfoService getShopInfoServiceImp() {
		return shopInfoServiceImp;
	}
	public void setShopInfoServiceImp(ShopInfoService shopInfoServiceImp) {
		this.shopInfoServiceImp = shopInfoServiceImp;
	}
	public UserService getUserServiceImp() {
		return userServiceImp;
	}
	public void setUserServiceImp(UserService userServiceImp) {
		this.userServiceImp = userServiceImp;
	}
	
	// 提供快速获取对象的方法
	public Map<String, Object> getRequest() {
		return (Map) ActionContext.getContext().get("request");
	}

	public Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}

	public Map<String, Object> getApplication() {
		return (Map)ActionContext.getContext().getApplication();
	}
		
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=gbk");
		response.setCharacterEncoding("gbk");
		return response;
	}
	 public Map<String, Object> getParameters() {
	        return ActionContext.getContext().getParameters();
	    }
}