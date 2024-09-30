package com.seiryo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seiryo.po.PageInfo;
import com.seiryo.po.StudentClean;
import com.seiryo.service.StudentCleanService;
@Controller
public class StudentCleanController {
	@Autowired
	private StudentCleanService studentCleanService;

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findStudentClean")
	public String findStudentClean(String s_studentid,String s_name, Integer s_dormitoryid, 
			Integer pageIndex, Integer pageSize, Model model) {
		PageInfo<StudentClean> di = studentCleanService.findPageInfo(s_studentid, s_name, s_dormitoryid, pageIndex, pageSize);
		model.addAttribute("di",di);
		return "studentclean_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportstudentcleanlist" , method = RequestMethod.POST)
    @ResponseBody
	public List<StudentClean> exportstudentcleanlist(){
		List<StudentClean> studentClean = studentCleanService.getAll();
		return studentClean;
	}

	/**
	 * 添加管理员信息
	 */
	@RequestMapping(value = "/addStudentClean" ,method = RequestMethod.POST)
	@ResponseBody
	public String addStudentClean( @RequestBody  StudentClean studentClean) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String create_time = now.format(formatter);
        studentClean.setCreate_time(create_time);
		int a = studentCleanService.addStudentClean(studentClean);
		return "studentclean_list";
	}

	/**
	 * 删除管理员信息；将请求体a_id写入参数a_id
	 */
	@RequestMapping( "/deleteStudentClean")
	@ResponseBody
	public String deleteStudentClean(Integer g_id) {
		int a = studentCleanService.deleteStudentClean(g_id);
		return "studentclean_list";
	}

	/**
	 * 修改管理员信息
	 */
	/**
	 * 将提交数据(a_id,a_username...)写入Admin对象
	 */
	@RequestMapping( value = "/updateStudentClean", method = RequestMethod.POST)
	@ResponseBody
	public String updateStudentClean(@RequestBody StudentClean studentClean) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String update_time = now.format(formatter);
        studentClean.setUpdate_time(update_time);
		int a = studentCleanService.updateStudentClean(studentClean);
		return "redirect:/findStudentClean";
	}


	/**
	 * 根据管理员Id搜索;将请求数据a_id写入参数a_id
	 */
	@RequestMapping( "/findStudentCleanById")
	public String findStudentCleanById( Integer g_id,HttpSession session) {
		StudentClean d = studentCleanService.findStudentCleanById(g_id);
		session.setAttribute("d",d);
		return "studentclean_edit";
	}
}
