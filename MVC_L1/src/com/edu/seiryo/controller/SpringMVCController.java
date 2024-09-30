package com.edu.seiryo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/springmvc")
public class SpringMVCController {
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("hello");
		return "success";
	}
	@RequestMapping(value="/testMethod1",method=RequestMethod.GET)
	public String testMethod1() {
		System.out.println("hello");
		return "success";
	}
	@RequestMapping(value="testAntPath/*/abc")
//	@RequestMapping(value="testAntPath/**/abc")
//	@RequestMapping(value="testAntPath/?/abc")
	public String testAntPath() {
		return "success";
	}
	
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		return "success";
	}
	
	
	@RequestMapping(value="/testRESTGet/{id}",method=RequestMethod.GET)
	public String testRESTGet(@PathVariable(value="id")Integer id) {
		System.out.println(id);
		return "success";
	
	}
	@RequestMapping(value="/testRESTGet/{id}",method=RequestMethod.POST)
	public String testRESTPost(@PathVariable(value="id")Integer id) {
		System.out.println(id);
		return "success";
	}
	@RequestMapping(value="/testRESTPut/{id}",method=RequestMethod.PUT)
	public String testRESTPut(@PathVariable(value="id")Integer id) {
		System.out.println(id);
		return "success";
	}
	@RequestMapping(value="/testRESTDelete/{id}",method=RequestMethod.DELETE)
	public String testRESTDelete(@PathVariable(value="id")Integer id) {
		System.out.println(id);
		return "success";
	}
}
