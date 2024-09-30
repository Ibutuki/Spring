package com.seiryo.po;

public class DormClean {
	private Integer g_id;
	private Integer d_id;
	private String d_dormbuilding;
	private String d_grade;
	private String create_time;
	private String update_time;
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_dormbuilding() {
		return d_dormbuilding;
	}
	public void setD_dormbuilding(String d_dormbuilding) {
		this.d_dormbuilding = d_dormbuilding;
	}
	public String getD_grade() {
		return d_grade;
	}
	public void setD_grade(String d_grade) {
		this.d_grade = d_grade;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public DormClean(Integer g_id, Integer d_id, String d_dormbuilding, String d_grade, String create_time,
			String update_time) {
		super();
		this.g_id = g_id;
		this.d_id = d_id;
		this.d_dormbuilding = d_dormbuilding;
		this.d_grade = d_grade;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public DormClean() {
		super();
	}
	@Override
	public String toString() {
		return "DormClean [d_id=" + d_id + ", g_id=" + g_id + ", d_dormbuilding=" + d_dormbuilding + ", d_grade="
				+ d_grade + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
}
