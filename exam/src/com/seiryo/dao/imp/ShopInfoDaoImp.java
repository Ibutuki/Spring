/**
 * 
 */
package com.seiryo.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.seiryo.util.BaseDaoImp;
import com.seiryo.dao.ShopInfoDao;
import com.seiryo.entity.ShopInfo;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao.imp
 * @file_name    ShopInfoDaoImp.java
 * @classname    ShopInfoDaoImp
 * @version      
 */
@Repository
public class ShopInfoDaoImp extends BaseDaoImp<ShopInfo> implements ShopInfoDao{

	@Override
	public List<ShopInfo> queryShopInfoByNameAndDescr(String name, String descr) {
		String queryString = "from ShopInfo where 1 = 1";
		List<String> a = new ArrayList<String>();
		if(name != null && name != "") {
			queryString += " and shopName like ?";
			a.add("%" + name + "%");
		}
		if(!descr.equals("all")) {
			queryString += " and descr = ?";
			a.add("descr");
		}
		String[] paramArray = a.toArray(new String[0]);
	    List<ShopInfo> list = (List<ShopInfo>) this.getHibernateTemplate().find(queryString, paramArray);
	    return list;
	}
}
