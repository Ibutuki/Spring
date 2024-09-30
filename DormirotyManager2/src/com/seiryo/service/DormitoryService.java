package com.seiryo.service;

import java.util.List;


import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;

public interface DormitoryService {
	public int addDormitory(Dormitory dormitory);    //添加管理员信息
	public int deleteDormitory(Integer g_id);   //删除管理员信息
	public int updateDormitory(Dormitory dormitory); //修改管理员信息
	public Dormitory findDormitoryById(Integer g_id);
	public List<Dormitory> getAll();
	//分页查询
	public PageInfo<Dormitory> findPageInfo(Integer s_dormitoryid, String d_dormbuilding, String a_name,
			Integer currentPage, Integer pageSize);
}
