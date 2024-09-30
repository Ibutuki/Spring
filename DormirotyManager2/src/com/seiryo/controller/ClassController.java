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

import com.seiryo.po.Class;
import com.seiryo.po.PageInfo;
import com.seiryo.service.ClassService;
@Controller
public class ClassController {
	@Autowired
	ClassService classService;


	/*
	 * id查,跳转到更新界面
	 */
	@RequestMapping("/findClassById")
	public String  findClassById(Integer c_id, HttpSession session) {
		Class c = classService.findClassById(c_id);
		session.setAttribute("c", c);
		return "class_edit";
	}
	@RequestMapping(value = "/updateClass",method = RequestMethod.POST)
	@ResponseBody
	public String updateClass(@RequestBody Class cla) {
		classService.updateClass(cla);
		return "redirect:/findClassById";
	};
	/**
	 * 添加class信息
	 */
	@RequestMapping(value = "/addClass" ,method = RequestMethod.POST)
	@ResponseBody
	public String addClass(@RequestBody Class cla) {
		int a = classService.addClass(cla);
		return "class_list";
	};

	/**
	 * 删除class信息；将请求体c_id写入参数c_id
	 */
	@RequestMapping( "/deleteClass")
	@ResponseBody
	public String deleteClass(Integer c_id) {
		int a = classService.deleteClass(c_id);
		return "class_list";
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findClass")
	public String findClass(Integer c_classid, String c_classname, String c_counsellor, 
			Integer pageIndex,Integer pageSize ,Model model) {

		PageInfo<Class> ci = classService.findPageInfo(c_classid, c_classname, c_counsellor, 
				pageIndex, pageSize);
		model.addAttribute("ci", ci);
		return "class_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportclasslist" , method = RequestMethod.POST)
    @ResponseBody
	public List<Class> exportclasslist(){
		List<Class> cla = classService.getAll();
		return cla;
	}
}	
