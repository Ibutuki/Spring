/**
 * 
 */
package com.seiryo.entity;

import java.sql.Date;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.entity
 * @file_name    ShopInfo.java
 * @classname    ShopInfo
 * @version      
 */
public class ShopInfo {
	private Integer id; 
	private String shopId;
	private String shopName;
	private Double price;
	private Double oldPrice;
	private String descr; 
	private Date insertDtm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer iD) {
		id = iD;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Date getInsertDtm() {
		return insertDtm;
	}
	public void setInsertDtm(Date insertDtm) {
		this.insertDtm = insertDtm;
	}
	
}
