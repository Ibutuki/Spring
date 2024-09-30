package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.Dormitory;

public interface DormitoryStudentDao {
	//获取总条数
//	public Integer totalCount(@Param("s_dormitoryid")Integer s_dormitoryid);
	//获取用户列表
//	public List<Dormitory> findDormitoryStudent(@Param("s_dormitoryid")Integer s_dormitoryid, 
//			@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);
	public List<Dormitory> findDormitoryStudent(@Param("s_dormitoryid")Integer s_dormitoryid);
}
