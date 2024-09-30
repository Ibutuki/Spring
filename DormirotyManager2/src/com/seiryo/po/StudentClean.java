package com.seiryo.po;

public class StudentClean {
	private Integer g_id;
	private Integer s_studentid;
	private String s_name;
	private Integer s_grade;
	private Integer s_classid;
	private String s_dormitoryid;
	private String update_time;
	private String create_time;
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public Integer getS_studentid() {
		return s_studentid;
	}
	public void setS_studentid(Integer s_studentid) {
		this.s_studentid = s_studentid;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public Integer getS_grade() {
		return s_grade;
	}
	public void setS_grade(Integer s_grade) {
		this.s_grade = s_grade;
	}
	public Integer getS_classid() {
		return s_classid;
	}
	public void setS_classid(Integer s_classid) {
		this.s_classid = s_classid;
	}
	public String getS_dormitoryid() {
		return s_dormitoryid;
	}
	public void setS_dormitoryid(String s_dormitoryid) {
		this.s_dormitoryid = s_dormitoryid;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public StudentClean(Integer s_studentid, String s_name, Integer s_grade, Integer s_classid, String s_dormitoryid,
			String update_time) {
		super();
		this.s_studentid = s_studentid;
		this.s_name = s_name;
		this.s_grade = s_grade;
		this.s_classid = s_classid;
		this.s_dormitoryid = s_dormitoryid;
		this.update_time = update_time;
	}
	public StudentClean() {
		super();
	}
	@Override
	public String toString() {
		return "StudentClean [s_studentid=" + s_studentid + ", s_name=" + s_name + ", s_grade=" + s_grade
				+ ", s_classid=" + s_classid + ", s_dormitoryid=" + s_dormitoryid + ", update_time=" + update_time
				+ "]";
	}
	
}
