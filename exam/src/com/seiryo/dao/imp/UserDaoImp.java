/**
 * 
 */
package com.seiryo.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seiryo.dao.UserDao;
import com.seiryo.entity.UserInfo;
import com.seiryo.util.BaseDaoImp;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
@Repository
public class UserDaoImp extends BaseDaoImp<UserInfo> implements UserDao{

	@Override
	public UserInfo login(UserInfo user) {
		List<UserInfo> list = this.getHibernateTemplate().find("from UserInfo where userName = ? and usePassword = ?",new String[]{user.getUserName(),user.getUsePassword()});
		 if (list != null && !list.isEmpty()) {
			 return list.get(0);
	     }
	     return null;
	}

}
