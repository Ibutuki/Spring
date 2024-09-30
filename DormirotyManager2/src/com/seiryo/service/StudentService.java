package com.seiryo.service;

import java.util.List;


import com.seiryo.po.PageInfo;
import com.seiryo.po.Student;

public interface StudentService {

	/**
	 * 进行分页查询
	 */

	public int addStudent(Student student);    //添加管理员信息
	public int deleteStudent(Integer a_id);   //删除管理员信息
	public int updateStudent(Student student); //修改管理员信息
	public Student findStudentById(Integer a_id);
	public List<Student> getAll();
	
	//分页查询
		public PageInfo<Student> findPageInfo(String s_name, Integer s_studentid,String s_classname,
				Integer s_classid,Integer currentPage, Integer pageSize);

}
