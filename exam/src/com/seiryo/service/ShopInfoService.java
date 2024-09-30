/**
 * 
 */
package com.seiryo.service;

import java.io.Serializable;
import java.util.List;

import com.seiryo.entity.ShopInfo;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.dao
 * @file_name    GoodsDao.java
 * @classname    
 * @version      
 */
public interface ShopInfoService {
	List<ShopInfo> query();
	List<ShopInfo> queryShopInfoByNameAndDescr(String name,String descri);
	ShopInfo get(Serializable shopId);
}
