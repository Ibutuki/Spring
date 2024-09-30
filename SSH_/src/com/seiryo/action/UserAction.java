package com.seiryo.action;
import java.util.List;

import com.seiryo.entity.User;
import com.seiryo.util.BaseAction;

public class UserAction extends BaseAction<User>{
	String msg = "";
	String url = "";
	public String login() {
		User user = this.getUserServiceImp().login(this.getModel());
		if(user != null) {
			url = query();
		}else {
			url = "index";
			msg = "账号或密码错误";
			this.getRequest().put("msg", msg);
		}
		return url;
	}
	public String query() {
		List<User> list = this.getUserServiceImp().query();
		this.getRequest().put("list", list);
		url="userslist";
		return url;
	}
	public String reg() {
		this.getUserServiceImp().save(this.getModel());
		url = "index";
		return url;
	}
	public String del() {
		this.getUserServiceImp().delete(this.getModel());
		url = query();
		return url;
	}
	public String updUser() {
		this.getUserServiceImp().update(this.getModel());
		url = query();
		return url;
	}
	public String loadUsers() {
		User user = this.getUserServiceImp().get(this.getModel().getId());
		this.getRequest().put("users",user);
		url = "usersInfo"; 
	    return url;
	}
}
