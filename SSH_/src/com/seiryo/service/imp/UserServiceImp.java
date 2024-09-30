package com.seiryo.service.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seiryo.dao.UserDao;
import com.seiryo.entity.User;
import com.seiryo.service.UserService;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void save(User user) {
		userDao.save(user);
	}
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	@Override
	public List<User> query() {
		return userDao.query();
	}
	@Override
	public User get(Serializable id) {
		return userDao.get(id);
	}
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
}
