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

import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormitoryService;
@Controller
public class DormitoryController {
	@Autowired
	private DormitoryService dormitoryService;

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findDormitory")
	public String findDormitory(Integer s_dormitoryid, String d_dormbuilding, String a_name, 
			Integer pageIndex, Integer pageSize, Model model) {
		PageInfo<Dormitory> di = dormitoryService.findPageInfo(s_dormitoryid, d_dormbuilding, a_name, pageIndex, pageSize);
		model.addAttribute("di",di);
		return "dormitory_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportdormitorylist" , method = RequestMethod.POST)
    @ResponseBody
	public List<Dormitory> exportdormitorylist(){
		List<Dormitory> dormitory = dormitoryService.getAll();
		return dormitory;
	}

	/**
	 * 添加管理员信息
	 */
	@RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
	@ResponseBody
	public String addDormitory( @RequestBody  Dormitory dormitory) {
		int a = dormitoryService.addDormitory(dormitory);
		return "dormitory_list";
	}

	/**
	 * 删除管理员信息；将请求体a_id写入参数a_id
	 */
	@RequestMapping( "/deleteDormitory")
	@ResponseBody
	public String deleteDormitory(Integer d_id) {
		int a = dormitoryService.deleteDormitory(d_id);
		return "dormitory_list";
	}

	/**
	 * 修改管理员信息
	 */
	/**
	 * 将提交数据(a_id,a_username...)写入Admin对象
	 */
	@RequestMapping( value = "/updateDormitory", method = RequestMethod.POST)
	@ResponseBody
	public String updateDormitory(@RequestBody Dormitory dormitory) {
		int a = dormitoryService.updateDormitory(dormitory);
		
		return "redirect:/findDormitory";
	}


	/**
	 * 根据管理员Id搜索;将请求数据a_id写入参数a_id
	 */
	@RequestMapping( "/findDormitoryById")
	public String findDormitoryById( Integer d_id,HttpSession session) {
		Dormitory d = dormitoryService.findDormitoryById(d_id);
		session.setAttribute("d",d);
		return "dormitory_edit";
	}
}
