/**
 * 
 */
package com.seiryo.entity;

/**
 * @author       outianchang
 * @date         2024Äê5ÔÂ4ÈÕ
 * @project_name Game
 * @package_name com.edu.seiryo.entity
 * @file_name    UserInfo.java
 * @classname    UserInfo
 * @version      
 */
public class UserInfo {
	private Integer ID;
	private String userName;
	private String usePassword;
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
	public String getUsePassword() {
		return usePassword;
	}
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}
	/**
	 * @param iD
	 * @param userName
	 * @param usePassword
	 */
	public UserInfo(Integer iD, String userName, String usePassword) {
		super();
		ID = iD;
		this.userName = userName;
		this.usePassword = usePassword;
	}
	/**
	 * 
	 */
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [ID=" + ID + ", userName=" + userName + ", usePassword=" + usePassword + "]";
	}
	
}
