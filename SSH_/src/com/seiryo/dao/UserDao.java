package com.seiryo.dao;

import java.io.Serializable;
import java.util.List;

import com.seiryo.entity.User;

public interface UserDao {
	void save(User user);
	void delete(User user);
	void update(User user);
	List<User> query();
	User get(Serializable id);
	User login(User user);
}
