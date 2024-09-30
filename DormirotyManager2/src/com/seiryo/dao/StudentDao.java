package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.Student;

public interface StudentDao {

	/**
	 * 进行分页查询
	 */

	//获取总条数
	public Integer totalCount(@Param("s_name") String s_name, @Param("s_studentid") Integer s_studentid,@Param("s_classid") Integer s_classid,@Param("s_classname") String s_classname);
	//获取用户列表
	public List<Student> getStudentList(@Param("s_name") String s_name, @Param("s_studentid") Integer s_studentid,@Param("s_classid") Integer s_classid,@Param("s_classname") String s_classname,
			@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int addStudent(Student student);    //添加管理员信息
	public int deleteStudent(Integer s_id);   //删除管理员信息
	public int updateStudent(Student student); //修改管理员信息
	public Student findStudentById(Integer s_id);
	public List<Student> getAll();
}
