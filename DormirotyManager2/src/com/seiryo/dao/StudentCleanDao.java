package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.StudentClean;

/*
 * 学生卫生
 */
public interface StudentCleanDao {
	/**
	 * 进行分页查询
	 */

	//获取总条数
	public Integer totalCount(@Param("s_studentid") String s_studentid, @Param("s_name") String s_name,@Param("s_dormitoryid") Integer s_dormitoryid);
	//获取用户列表
	public List<StudentClean> getStudentCleanList(@Param("s_studentid") String s_studentid, @Param("s_name") String s_name,@Param("s_dormitoryid") Integer s_dormitoryid, 
			@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

	public int addStudentClean(StudentClean studentClean);    //添加管理员信息
	public int deleteStudentClean(Integer g_id);   //删除管理员信息
	public int updateStudentClean(StudentClean studentClean); //修改管理员信息
	public StudentClean findStudentCleanById(Integer g_id);
	public List<StudentClean> getAll();
}
