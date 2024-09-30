package com.edu.seiryo.mapper;

import com.edu.seiryo.entity.Employee;

public interface EmployeeMapper {
	 /**
     * 添加
     */
    int save(Employee employee);
    /**
     * 清空数据
     */
    void truncateAll();
    
    /**
     * 清空employee_temp数据
     */
    void truncateTemp();
}
