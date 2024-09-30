package com.edu.seiryo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springmvc")
public class Demo2 {
	public String helloworld() {
		System.out.println("helol");
		return "success";
	}
}	
