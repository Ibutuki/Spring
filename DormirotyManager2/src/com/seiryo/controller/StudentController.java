package com.seiryo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seiryo.po.PageInfo;
import com.seiryo.po.Student;
import com.seiryo.service.StudentService;
@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	/*
	 * id查,跳转到更新界面
	 */
	@RequestMapping("/findStudentById")
	public String  findStudentById(Integer s_id, HttpSession session) {
		Student s = studentService.findStudentById(s_id);
		session.setAttribute("s", s);
		return "student_edit";
	}
	/**
	 * 添加class信息
	 */
	@RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
	@ResponseBody
	public String addStudent(@RequestBody Student student) {
		int a = studentService.addStudent(student);
		return "student_list";
	};

	/**
	 * 更新class信息
	 */
	@RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST)
	@ResponseBody
	public String updateStudent(@RequestBody Student student) {
		int a = studentService.updateStudent(student);
		return "student_list";
	};
	/**
	 * 删除class信息；将请求体c_id写入参数c_id
	 */
	@RequestMapping( "/deleteStudent")
	@ResponseBody
	public String deleteStudent(Integer s_id) {
		int a = studentService.deleteStudent(s_id);
		return "student_list";
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findStudent")
	public String findStudent(Integer s_studentid, String s_name, String s_classname, Integer s_classid, 
			Integer pageIndex,Integer pageSize ,Model model) {

		PageInfo<Student> pi = studentService.findPageInfo(s_name, s_studentid, s_classname, s_classid, 
				pageIndex, pageSize);
		model.addAttribute("pi", pi);
		return "student_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportstudentlist" , method = RequestMethod.POST)
    @ResponseBody
	public List<Student> exportstudentlist(){
		List<Student> student = studentService.getAll();
		return student;
	}
}
