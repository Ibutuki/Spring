package com.edu.seiryo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.seiryo.pojo.Users;
@Repository
public interface UserDao {
	Users login(String name, String pwd);
	List<Users> queryAll();
}
