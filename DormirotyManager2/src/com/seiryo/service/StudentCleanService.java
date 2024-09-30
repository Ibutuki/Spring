package com.seiryo.service;

import java.util.List;

import com.seiryo.po.PageInfo;
import com.seiryo.po.StudentClean;

public interface StudentCleanService {

	//分页查询
	public PageInfo<StudentClean> findPageInfo(String s_studentid, String s_name, Integer s_dormitoryid, 
			 Integer currentPage, Integer pageSize);

	public int addStudentClean(StudentClean studentClean);    //添加管理员信息
	public int deleteStudentClean(Integer a_id);   //删除管理员信息
	public int updateStudentClean(StudentClean studentClean); //修改管理员信息
	public StudentClean findStudentCleanById(Integer a_id);
	public List<StudentClean> getAll();
}
