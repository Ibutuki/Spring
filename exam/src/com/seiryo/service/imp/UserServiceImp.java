/**
 * 
 */
package com.seiryo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seiryo.dao.UserDao;
import com.seiryo.dao.imp.UserDaoImp;
import com.seiryo.entity.UserInfo;
import com.seiryo.service.UserService;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
@Service
public class UserServiceImp implements UserService{
	private UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserInfo login(UserInfo user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}


}
