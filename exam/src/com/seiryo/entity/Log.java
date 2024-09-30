/**
 * 
 */
package com.seiryo.entity;

import java.sql.Date;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.entity
 * @file_name    Log.java
 * @classname    Log
 * @version      
 */
public class Log {
	private Integer ID;
	private String userName;
	private Date loginDtm;
	private Date exitDtm;
	private UserInfo userInfo;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getLoginDtm() {
		return loginDtm;
	}
	public void setLoginDtm(Date loginDtm) {
		this.loginDtm = loginDtm;
	}
	public Date getExitDtm() {
		return exitDtm;
	}
	public void setExitDtm(Date exitDtm) {
		this.exitDtm = exitDtm;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	/**
	 * 
	 */
	public Log() {
		super();
	}
	/**
	 * @param iD
	 * @param userName
	 * @param loginDtm
	 * @param exitDtm
	 * @param userInfo
	 */
	public Log(Integer iD, String userName, Date loginDtm, Date exitDtm, UserInfo userInfo) {
		super();
		ID = iD;
		this.userName = userName;
		this.loginDtm = loginDtm;
		this.exitDtm = exitDtm;
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "Log [ID=" + ID + ", userName=" + userName + ", loginDtm=" + loginDtm + ", exitDtm=" + exitDtm
				+ ", userInfo=" + userInfo + "]";
	}
	
}
