package com.edu.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edu.seiryo.pojo.Users;
@Repository
public interface UserDao {
	List<Users> queryAll();
	Users get(Integer id);
	int toAddUser(@Param("user")Users user);
	Users queryUser(String name);
	int update(@Param("user")Users user);
	int del(Integer id);
}
