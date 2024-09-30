package com.edu.seiryo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.seiryo.mapper.DepartmentMapper;
import com.edu.seiryo.mapper.EmployeeMapper;
import com.edu.seiryo.pojo.Department;
import com.edu.seiryo.pojo.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	DepartmentMapper departmentMapper;
	@GetMapping("/emps")
	public String list(Model model){
		List<Employee> employees = employeeMapper.getEmployees();
		System.out.println(employees.get(0));
		 //将结果放在请求中
		model.addAttribute("emps",employees);
		return "emp/list";
	}
//	@GetMapping("/emp")
//	public String toAddPage() {
//		return "emp/add";
//	}
	@PostMapping("/emp")
	public String add(Employee employee){
		employeeMapper.save(employee);
		return "redirect:/emps";
	}
	@GetMapping("/emp/{id}")
	public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
		 Employee employee = employeeMapper.get(id);
		    System.out.println(employee);
		    model.addAttribute("emp",employee);
		    List<Department> departments = departmentMapper.getDepartments();
		    model.addAttribute("departments",departments);
		    return "emp/update";
	}
	@Delete(value = { "/emp" })
	public String update(Employee employee){
		employeeMapper.update(employee);
		return "redirect:/emps";
	}
	@PostMapping("/emp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id, Model model) {
		employeeMapper.delete(id);
	    return "redirect:/emps";
	}
	@GetMapping("/user/loginOut")
	 public String loginOut(HttpSession session){
		 session.invalidate();
		 return "redirect:/index.html";
	 }
}
