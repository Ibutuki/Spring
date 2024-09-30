package com.seiryo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seiryo.po.Dormitory;
import com.seiryo.service.DormitoryStudentService;
@Controller
public class DormitoryStudentController {
	@Autowired
	DormitoryStudentService dormitoryStudentService;
	@RequestMapping("/findDormitoryStudent")
	public String findDormitoryStudent(Integer s_dormitoryid,Integer pageIndex, Integer pageSize, Model model) {
		List<Dormitory> ds = dormitoryStudentService.findDormitoryStudent(s_dormitoryid);
		System.out.println(ds.get(1));
		model.addAttribute("ds", ds);
		return "dormitory_Studentlist";
	}
}
