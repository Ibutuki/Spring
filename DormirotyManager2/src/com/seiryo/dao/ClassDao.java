package com.seiryo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.Class;

public interface ClassDao {
	List<Class> getAll();
	int updateClass(Class cla);
	//id查
	Class findClassById(Integer c_id);
	int addClass(Class cla);
	int deleteClass(Integer c_id);
	//exportclasslist导出
	
	/**
	 * 进行分页查询
	 */
	//获取总条数
	Integer totalCount(@Param("c_classid") Integer c_classid, @Param("c_classname") String c_classname,@Param("c_counsellor") String c_counsellor);
	//获取用户列表
	List<Class> getClassList(@Param("c_classid") Integer c_classid, @Param("c_classname") String c_classname,@Param("c_counsellor") String c_counsellor, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

}
