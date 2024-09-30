package com.seiryo.po;

public class Visitor {
	private Integer v_id;
	private String v_name;
	private Integer v_phone;
	private Integer v_dormitoryid;
	private String v_dormbuilding;
	private String create_time;
	public Integer getV_id() {
		return v_id;
	}
	public void setV_id(Integer v_id) {
		this.v_id = v_id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public Integer getV_phone() {
		return v_phone;
	}
	public void setV_phone(Integer v_phone) {
		this.v_phone = v_phone;
	}
	public Integer getV_dormitoryid() {
		return v_dormitoryid;
	}
	public void setV_dormitoryid(Integer v_dormitoryid) {
		this.v_dormitoryid = v_dormitoryid;
	}
	public String getV_dormbuilding() {
		return v_dormbuilding;
	}
	public void setV_dormbuilding(String v_dormbuilding) {
		this.v_dormbuilding = v_dormbuilding;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public Visitor(Integer v_id, String v_name, Integer v_phone, Integer v_dormitoryid, String v_dormbuilding,
			String create_time) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_phone = v_phone;
		this.v_dormitoryid = v_dormitoryid;
		this.v_dormbuilding = v_dormbuilding;
		this.create_time = create_time;
	}
	public Visitor() {
		super();
	}
	@Override
	public String toString() {
		return "Visitor [v_id=" + v_id + ", v_name=" + v_name + ", v_phone=" + v_phone + ", v_dormitoryid="
				+ v_dormitoryid + ", v_dormbuilding=" + v_dormbuilding + ", create_time=" + create_time + "]";
	}
}	
