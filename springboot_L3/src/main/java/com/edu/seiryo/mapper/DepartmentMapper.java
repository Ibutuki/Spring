package com.edu.seiryo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.edu.seiryo.pojo.Department;
@Mapper
public interface DepartmentMapper {
	List<Department> getDepartments();
	Department getDepartment();
}
