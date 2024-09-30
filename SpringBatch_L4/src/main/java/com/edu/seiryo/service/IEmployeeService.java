package com.edu.seiryo.service;

import java.io.IOException;

import com.edu.seiryo.entity.Employee;

public interface IEmployeeService {
	/**
     * 保存
     */
    void save(Employee employee);
    /**
     * 初始化数据：生成50w数据
     */
    void dataInit() throws IOException;
    /**
     * 清空数据
     */
    void truncateAll();
    
    /**
     * 清空employee_temp数据
     */
    void truncateTemp();
}
