package com.seiryo.pojo;

public class DateDTO {
	private int year;
    private int month;
    private int day;
    
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public DateDTO(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public DateDTO() {
		super();
	}
	@Override
	public String toString() {
		return "DateDTO [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
    
}
