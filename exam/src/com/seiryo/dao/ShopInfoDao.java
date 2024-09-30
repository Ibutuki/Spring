/**
 * 
 */
package com.seiryo.dao;

import java.io.Serializable;
import java.util.List;

import com.seiryo.entity.ShopInfo;


/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Gamex
 * @package_name com.edu.seiryo.dao
 * @file_name    ShopInfoDao.java
 * @classname    ShopInfoDao
 * @version      
 */
public interface ShopInfoDao {
	List<ShopInfo> query();
	List<ShopInfo> queryShopInfoByNameAndDescr(String name,String descri);
	ShopInfo get(Serializable shopId);
}
