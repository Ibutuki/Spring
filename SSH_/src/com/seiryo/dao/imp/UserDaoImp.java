package com.seiryo.dao.imp;
import com.seiryo.entity.User;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seiryo.dao.UserDao;
import com.seiryo.util.BaseDaoImp;
@Repository
public class UserDaoImp extends BaseDaoImp<User> implements UserDao{

	@Override
	public User login(User user) {
		List<User> list = this.getHibernateTemplate().find("from User where userName = ? and pwd = ?",new String[]{user.getUserName(),user.getPwd()});
		 if (list != null && !list.isEmpty()) {
	            return list.get(0);
	        }
	        return null; // 处理未找到用户的情况
	}
}
