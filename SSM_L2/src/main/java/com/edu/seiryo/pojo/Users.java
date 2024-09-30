package com.edu.seiryo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	private Integer id;
	private String name;
	private String pwd;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Users(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	
	public Users(Integer id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
}
