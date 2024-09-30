package com.edu.seiryo.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.seiryo.pojo.Users;
import com.edu.seiryo.service.UserService;
import com.edu.seiryo.service.imp.UserServiceImp;
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	

	@RequestMapping("/allUser")
	public String queryAll(Model model) {
		List<Users> list = userService.queryAll();
		model.addAttribute("list", list);
		return "allUser";
	}
	
	//新增的添加
	@RequestMapping(value = "/toAddUser",method = RequestMethod.POST)
	public String toAddUser(Users user) {
		userService.toAddUser(user);
		return "redirect:/user/allUser";
	}
	//更新
	@RequestMapping(value="/toAddUser",method = RequestMethod.PUT)
	public String update(Users user) {
		userService.update(user);
		return "redirect:/user/allUser";
	}
	//新增input界面跳转
	@RequestMapping(value="/update",method = RequestMethod.GET)
	public String addRedirect(Model model) {
		return "input";
	}
	//更新input界面跳转
	@RequestMapping(value="/update/{id}",method = RequestMethod.GET)
	public String update(
			@PathVariable("id") Integer id,
			Model model) {
		System.out.println(id);
		Users user = userService.get(id);
		model.addAttribute("user", user);
		return "input";
	}
	@RequestMapping("/queryUser")
	public String queryUser(@RequestParam("queryUserName")String name,Model model) {
		Users user  = userService.queryUser(name);
		List<Users> list = new ArrayList<Users>();
		list.add(user);
		model.addAttribute("list", list);
		return "allUser";
	}

	@RequestMapping(value="/del/{id}",method = RequestMethod.DELETE)
	public String del(@PathVariable("id")Integer id) {
		userService.del(id);
		return "redirect:/user/allUser";
	}
}