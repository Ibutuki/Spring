package com.edu.seiryo.service.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.pojo.Users;
import com.edu.seiryo.service.UserService;
@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Users> queryAll() {
		List<Users> list = userDao.queryAll();
		return list;
	}

	@Override
	public int toAddUser(Users user) {
		return userDao.toAddUser(user);
	}

	@Override
	public Users queryUser(String name) {
		// TODO Auto-generated method stub
		return userDao.queryUser(name);
	}

	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return userDao.del(id);
	}

	@Override
	public Users get(Integer id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

}