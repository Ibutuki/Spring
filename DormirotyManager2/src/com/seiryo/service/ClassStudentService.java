package com.seiryo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.seiryo.po.Class;

public interface ClassStudentService {
	public List<Class> findClassStudent(@Param("c_classid")Integer c_classid, @Param("c_classname")String c_classname);
}
