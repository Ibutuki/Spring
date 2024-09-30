package com.edu.seiryo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.edu.seiryo.pojo.Employee;
@Mapper
public interface EmployeeMapper {
	List<Employee> getEmployees();
	int save(Employee employee);
	Employee get(Integer id);
	int delete(Integer id);
	int update(Employee employee);
}
