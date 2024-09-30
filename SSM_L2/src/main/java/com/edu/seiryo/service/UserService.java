package com.edu.seiryo.service;

import java.util.List;


import com.edu.seiryo.pojo.Users;

public interface UserService {
	List<Users> queryAll();
	int toAddUser(Users user);
	Users queryUser(String name);
	int update(Users user);
	int del(Integer id);
	Users get(Integer id);
}
