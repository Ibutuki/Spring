package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.Dormitory;


public interface DormitoryDao {
	public int addDormitory(Dormitory dormitory);    //添加管理员信息
	public int deleteDormitory(Integer g_id);   //删除管理员信息
	public int updateDormitory(Dormitory dormitory); //修改管理员信息
	public Dormitory findDormitoryById(Integer g_id);
	public List<Dormitory> getAll();
	/**
	 * 进行分页查询
	 */

	//获取总条数
	public Integer totalCount(@Param("s_dormitoryid") Integer s_dormitoryid, @Param("d_dormbuilding") String d_dormbuilding,@Param("a_name") String a_name);
	//获取用户列表
	public List<Dormitory> getDormitoryList(@Param("s_dormitoryid") Integer s_dormitoryid, @Param("d_dormbuilding") String d_dormbuilding,@Param("a_name") String a_name,
			@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);


}
