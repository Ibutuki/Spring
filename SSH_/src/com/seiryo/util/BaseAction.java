package com.seiryo.util;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
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
	@Autowired
	// 注入需要使用的service，提供get、set方法
	UserService userServiceImp;
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
}