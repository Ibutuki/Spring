package com.edu.seiryo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edu.seiryo.mapper.DepartmentMapper;
import com.edu.seiryo.pojo.Department;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentMapper departmentMapper;
	@GetMapping("/emp")
	public String ToaddPage(Model model) {
		List<Department> departments = departmentMapper.getDepartments();
		System.out.println(departments.get(1));
		model.addAttribute("departments", departments);
		return "emp/add";
	}
}