/**
 * 
 */
package com.seiryo.service.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seiryo.dao.ShopInfoDao;
import com.seiryo.dao.imp.ShopInfoDaoImp;
import com.seiryo.entity.ShopInfo;
import com.seiryo.service.ShopInfoService;

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
public class ShopInfoServiceImp implements ShopInfoService{
	private ShopInfoDao ShopInfoDao;
	@Autowired
	public void setShopInfoDao(ShopInfoDao shopInfoDao) {
		ShopInfoDao = shopInfoDao;
	}

	@Override
	public List<ShopInfo> query() {
		// TODO Auto-generated method stub
		return ShopInfoDao.query();
	}

	@Override
	public List<ShopInfo> queryShopInfoByNameAndDescr(String name, String descri) {
		// TODO Auto-generated method stub
		return ShopInfoDao.queryShopInfoByNameAndDescr(name, descri);
	}

	@Override
	public ShopInfo get(Serializable shopId) {
		// TODO Auto-generated method stub
		return ShopInfoDao.get(shopId);
	}
	

}
