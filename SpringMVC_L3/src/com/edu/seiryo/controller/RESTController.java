package com.edu.seiryo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.seiryo.dao.DepartmentDao;
import com.edu.seiryo.dao.EmployeeDao;
import com.edu.seiryo.entity.Employee;



@Controller
public class RESTController {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;
	
	@RequestMapping("/enter")
	public String enter(Map<String,Object> map) {
		map.put("emps", employeeDao.getAll());
		return "index";
	}
	//update
	@RequestMapping(value="/emp/{id}",method = RequestMethod.GET)
	public String update(
			@PathVariable("id") Integer id,
			Model model) {
		Employee emp = employeeDao.get(id);
		model.addAttribute("emp", emp);
		model.addAttribute("dpm", departmentDao.getDepartments());
		return "input";
	}
	
	//queryID
	@RequestMapping(value="/emp",method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("emp",new Employee());
		model.addAttribute("dpm", departmentDao.getDepartments());
		return "input";
	}
	//add
	@RequestMapping(value="/emp",method = RequestMethod.POST)
	public String add(Employee emp) {
		employeeDao.save(emp);
		return "redirect:/enter";
	}
	//updatePut
	@RequestMapping(value="/emp",method = RequestMethod.PUT)
	public String put(Employee emp) {
		employeeDao.save(emp);
		return "redirect:/enter";
	}
	@RequestMapping(value="/emp/{id}",method = RequestMethod.DELETE)
	public String delete(
			@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/enter";
	}
}
