package com.edu.seiryo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping({"/","/index.html"})
	 public String index(){
		return "index";
	 }
	@RequestMapping("/user/login")
	public String login(String username, String password, HttpSession session,HttpServletRequest requset) {
		if("admin".equals(username) && "123".equals(password)) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			return "dashboard";
		}
		requset.setAttribute("msg", "用户账号或密码错误");
		return "index";
	}
}
