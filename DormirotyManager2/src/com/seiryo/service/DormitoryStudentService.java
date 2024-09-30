package com.seiryo.service;

import java.util.List;

import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;

public interface DormitoryStudentService {
	//分页查询
//	public PageInfo<Dormitory> findPageInfo(Integer a_username, Integer pageIndex, Integer pageSize);
	public List<Dormitory> findDormitoryStudent(Integer s_dormitoryid);
}
