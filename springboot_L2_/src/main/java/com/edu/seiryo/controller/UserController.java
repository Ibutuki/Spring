package com.edu.seiryo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edu.seiryo.mapper.UserMapper;

@RestController
public class UserController {
	@Autowired
	UserMapper userMapper;
	@GetMapping("/allUser")
	public List<User> allUser(){
		return userMapper.allUsers();
	}
	@GetMapping("/allUser/{id}")
	public User getUser(@PathVariable("id") Integer id){
		return userMapper.getUser(id);
	}
}
