package com.seiryo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seiryo.po.Class;
import com.seiryo.service.ClassStudentService;

@Controller
public class ClassStudentController {
	@Autowired
	ClassStudentService classStudentService;
	@RequestMapping("/findClassStudent")
	public String findClassStudent(Integer c_classid, String c_classname,Integer pageIndex, Integer pageSize, Model model) {
		List<Class> cs = classStudentService.findClassStudent(c_classid, c_classname);
		model.addAttribute("cs", cs);
		return "class_Studentlist";
	}
}
