package com.edu.seiryo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.seiryo.pojo.Users;
import com.edu.seiryo.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/allUser")
	public String queryAll(Model model) {
		System.out.println("123");
		List<Users> list = userService.queryAll();
		model.addAttribute("list", list);
		return "allUser";
	}
}