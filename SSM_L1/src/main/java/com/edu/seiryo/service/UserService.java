package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.pojo.Users;

public interface UserService {
	Users login(String name, String pwd);
	List<Users> queryAll();
}
