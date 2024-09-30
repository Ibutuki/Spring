package com.edu.seiryo.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.seiryo.pojo.User;

@Controller
public class DemoController {
	@RequestMapping("/restRequestParam")
	public String testRequestParam(
			@RequestParam(value="username")String username,
			@RequestParam(value="age",required=false,defaultValue="0")int age) {
		System.out.println("testRequestParam - username="+ username +",age"+age);
		return "success";
	}
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(
			@RequestHeader(value="Accept-language")String al) {
		System.out.println(al);
		return "success";
	}
	@RequestMapping(value="/handle6")
	public String handle6(
			@CookieValue(value="sessionId",required=false)String sessionId,
			@RequestParam(value="age")int age) {
		System.out.println(sessionId);
		return "success";
	}
	@RequestMapping("/testPOJO")
	public String testPOJO(User user) {
		System.out.println("testPojo" + user);
		return "success";
	}
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getParameter("name"));
		return "success";
	}
	
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = "success";
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("name", new String("new"));
		return mv;
	}
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object>map) {
		System.out.println(map.getClass().getName());
		map.put("names",Arrays.asList("Tom","H","G"));
		return "success";
	}
}
