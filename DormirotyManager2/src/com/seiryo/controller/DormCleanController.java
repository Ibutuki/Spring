package com.seiryo.controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seiryo.po.DormClean;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormCleanService;

@Controller
public class DormCleanController {
	  // 依赖注入
	@Autowired
	private DormCleanService dormCleanService;

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findDormClean")
	public String findDormClean(String d_dormbuilding, Integer pageIndex,
							Integer d_id ,Integer pageSize, Model model) {
		PageInfo<DormClean> di = dormCleanService.findPageInfo(d_id, d_dormbuilding, 
				pageIndex, pageSize);
		model.addAttribute("di",di);
		return "dormclean_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportdormcleanlist" , method = RequestMethod.POST)
    @ResponseBody
	public List<DormClean> exportdormcleanlist(){
		List<DormClean> dormClean = dormCleanService.getAll();
		return dormClean;
	}

	/**
	 * 添加管理员信息
	 */
	@RequestMapping(value = "/addDormClean" ,method = RequestMethod.POST)
	@ResponseBody
	public String addDormClean( @RequestBody  DormClean dormClean) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String create_time = now.format(formatter);
        dormClean.setCreate_time(create_time);
		int a = dormCleanService.addDormClean(dormClean);
		return "dormclean_list";
	}

	/**
	 * 删除管理员信息；将请求体a_id写入参数a_id
	 */
	@RequestMapping( "/deleteDormClean")
	@ResponseBody
	public String deleteDormClean(Integer g_id) {
		int a = dormCleanService.deleteDormClean(g_id);
		return "dormclean_list";
	}

	/**
	 * 修改管理员信息
	 */
	/**
	 * 将提交数据(a_id,a_username...)写入Admin对象
	 */
	@RequestMapping( value = "/updateDormClean", method = RequestMethod.POST)
	@ResponseBody
	public String updateDormClean(@RequestBody DormClean dormClean) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String update_time = now.format(formatter);
        dormClean.setUpdate_time(update_time);
		int a = dormCleanService.updateDormClean(dormClean);
		return "redirect:/findDormClean";
	}


	/**
	 * 根据管理员Id搜索;将请求数据a_id写入参数a_id
	 */
	@RequestMapping( "/findDormCleanById")
	public String findDormCleanById( Integer g_id,HttpSession session) {
		DormClean d = dormCleanService.findDormCleanById(g_id);
		session.setAttribute("d",d);
		return "dormclean_edit";
	}
}
