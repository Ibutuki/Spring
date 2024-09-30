/**
 * 
 */
package com.seiryo.entity;


import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

/**
 * @author       outianchang
 * @date         2024��5��4��
 * @project_name Game
 * @package_name com.edu.seiryo.entity
 * @file_name    order.java
 * @classname    order
 * @version      
 */
public class Order {
	private Integer ID;
	private String orderId;
    private Date createDtm;
    private Integer state;
    private String stateOut;
	
    public String getStateOut() {
		return stateOut;
	}
    public void setStateOut() {
		if(this.state == 0){
			this.stateOut = "待审核 "; 
		}else if(this.state == 1){
			this.stateOut = "已审核 ";
		}else if(this.state == 2){
			this.stateOut = "已付款";
		}else if(this.state == 3){
			this.stateOut = "已发货";
		}
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
	public void setOrderId(String orderI) {
		this.orderId = orderI;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
		setStateOut();
	}


	
	public Date getCreateDtm() {
		return createDtm;
	}
	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}
	/**
	 * 
	 */
	public Order() {
		super();
	}
	/**
	 * @param iD
	 * @param orderId
	 * @param createDtm
	 * @param state
	 * @param stateOut
	 */
	public Order(Integer iD, String orderId, Date createDtm, Integer state, String stateOut) {
		super();
		ID = iD;
		this.orderId = orderId;
		this.createDtm = createDtm;
		this.state = state;
		this.stateOut = stateOut;
	}
	@Override
	public String toString() {
		return "Order [ID=" + ID + ", orderId=" + orderId + ", createDtm=" + createDtm + ", state=" + state
				+ ", stateOut=" + stateOut + "]";
	}
    
}
