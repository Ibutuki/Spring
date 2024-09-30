/**
 * 
 */
package com.seiryo.entity;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.entity
 * @file_name    OrderDetail.java
 * @classname    OrderDetail
 * @version      
 */
public class OrderDetail {
	private Integer ID ;
	private String orderId;
	private String shopId;
	private Integer quantity;
	private Order order;
	private ShopInfo shopInfo;
	private Double totalPrice;
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public ShopInfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	/**
	 * @param iD
	 * @param orderId
	 * @param shopId
	 * @param quantity
	 * @param order
	 * @param shopInfo
	 * @param totalPrice
	 */
	public OrderDetail(Integer iD, String orderId, String shopId, Integer quantity, Order order, ShopInfo shopInfo,
			Double totalPrice) {
		super();
		ID = iD;
		this.orderId = orderId;
		this.shopId = shopId;
		this.quantity = quantity;
		this.order = order;
		this.shopInfo = shopInfo;
		this.totalPrice = totalPrice;
	}
	/**
	 * 
	 */
	public OrderDetail() {
		super();
	}
	@Override
	public String toString() {
		return "OrderDetail [ID=" + ID + ", orderId=" + orderId + ", shopId=" + shopId + ", quantity=" + quantity
				+ ", order=" + order + ", shopInfo=" + shopInfo + ", totalPrice=" + totalPrice + "]";
	}
	
}
