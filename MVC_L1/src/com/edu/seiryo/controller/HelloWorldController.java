package com.edu.seiryo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HelloWorldController {
	@RequestMapping(value="/helloworld",method=RequestMethod.GET)
	public String helloWorld() {
		System.out.println("hello");
		return "success";
	}
	@RequestMapping(value="springmvc/helloworld",method=RequestMethod.GET)
	public String helloWorld1() {
		System.out.println("hello1");
		return "success";
	}
}
