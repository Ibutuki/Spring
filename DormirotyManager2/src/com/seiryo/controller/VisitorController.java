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
import com.seiryo.po.Visitor;
import com.seiryo.service.VisitorService;
@Controller
public class VisitorController {
	@Autowired
	private VisitorService visitorService;

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findVisitor")
	public String findVisitor(String v_name,String v_phone,
			Integer pageIndex, Integer pageSize, Model model) {
		PageInfo<Visitor> pi = visitorService.findPageInfo(v_name, v_phone, pageIndex, pageSize);
		model.addAttribute("pi",pi);
		return "visitor_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportvisitorlist" , method = RequestMethod.POST)
    @ResponseBody
	public List<Visitor> exportvisitorlist(){
		List<Visitor> visitor = visitorService.getAll();
		return visitor;
	}

	/**
	 * 添加管理员信息
	 */
	@RequestMapping(value = "/addVisitor" ,method = RequestMethod.POST)
	@ResponseBody
	public String addVisitor( @RequestBody  Visitor visitor) {
		int a = visitorService.addVisitor(visitor);
		return "visitor_list";
	}


}
