package com.seiryo.po;

public class DormRepair {
	private Integer r_id;
	private Integer d_id;
	private String d_dormbuilding;
	private String r_name;
	private String reason;
	private String create_time;
	private String update_time;
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
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
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public DormRepair(Integer r_id, Integer d_id, String d_dormbuilding, String r_name, String reason,
			String create_time, String update_time) {
		super();
		this.r_id = r_id;
		this.d_id = d_id;
		this.d_dormbuilding = d_dormbuilding;
		this.r_name = r_name;
		this.reason = reason;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public DormRepair() {
		super();
	}
	@Override
	public String toString() {
		return "DormRepair [r_id=" + r_id + ", d_id=" + d_id + ", d_dormbuilding=" + d_dormbuilding + ", r_name="
				+ r_name + ", reason=" + reason + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
}
