package com.edu.seiryo.service.imp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.seiryo.dao.UserDao;
import com.edu.seiryo.pojo.Users;
import com.edu.seiryo.service.UserService;

public class UserServiceImp implements UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Users login(String name, String pwd) {
		Users user = userDao.login(name, pwd);
		return user;
	}

	@Override
	public List<Users> queryAll() {
		List<Users> list = userDao.queryAll();
		return list;
	}

}