package com.seiryo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seiryo.po.DormRepair;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormrepairService;
@Controller
public class DormrepairController {
	@Autowired
	private DormrepairService dormrepairService;

	/**
	 * 分页查询
	 */
	@RequestMapping(value = "/findDormRepair")
	public String findDormRepair(Integer d_id, String d_dormbuilding,
			Integer pageIndex, Integer pageSize, Model model) {
		PageInfo<DormRepair> di = dormrepairService.findPageInfo(d_id, d_dormbuilding, pageIndex, pageSize);
		model.addAttribute("di",di);
		return "dormrepair_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportdormrepairlist" , method = RequestMethod.POST)
    @ResponseBody
	public List<DormRepair> exportdormrepairlist(){
		List<DormRepair> dormRepair = dormrepairService.getAll();
		return dormRepair;
	}

	/**
	 * 添加管理员信息
	 */
	@RequestMapping(value = "/addDormRepair" ,method = RequestMethod.POST)
	@ResponseBody
	public String addDormRepair( @RequestBody  DormRepair dormRepair) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String create_time = now.format(formatter);
		dormRepair.setCreate_time(create_time);
		int a = dormrepairService.addDormRepair(dormRepair);
		return "dormrepair_list";
	}

	/**
	 * 删除管理员信息；将请求体a_id写入参数a_id
	 */
	@RequestMapping( "/deleteDormRepair")
	@ResponseBody
	public String deleteDormRepair(Integer r_id) {
		int a = dormrepairService.deleteDormRepair(r_id);
		return "dormrepair_list";
	}

	/**
	 * 修改管理员信息
	 */
	/**
	 * 将提交数据(a_id,a_username...)写入Admin对象
	 */
	@RequestMapping( value = "/updateDormRepair", method = RequestMethod.POST)
	@ResponseBody
	public String updateDormRepair(@RequestBody DormRepair dormRepair) {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String update_time = now.format(formatter);
		dormRepair.setUpdate_time(update_time);
		int a = dormrepairService.updateDormRepair(dormRepair);
		return "redirect:/findDormRepair";
	}


	/**
	 * 根据管理员Id搜索;将请求数据a_id写入参数a_id
	 */
	@RequestMapping( "/findDormRepairById")
	public String findDormRepairById( Integer r_id,HttpSession session) {
		DormRepair d = dormrepairService.findDormRepairById(r_id);
		session.setAttribute("d",d);
		return "dormrepair_edit";
	}
}
