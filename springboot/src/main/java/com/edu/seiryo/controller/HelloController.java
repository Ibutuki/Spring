package com.edu.seiryo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		System.out.println("hello");
		return "hello";
	}
}
