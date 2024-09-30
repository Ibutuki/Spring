package com.seiryo.service;

import java.io.Serializable;
import java.util.List;

import com.seiryo.entity.User;

public interface UserService {
	void save(User user);
	void delete(User user);
	void update(User user);
	List<User> query();
	User get(Serializable id);
	User login(User user);
}
