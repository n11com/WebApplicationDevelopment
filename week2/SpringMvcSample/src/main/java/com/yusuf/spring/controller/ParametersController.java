package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametersController {

	@RequestMapping("/params")
	public String helloWorld(@RequestParam String param1,
							 @RequestParam("intParam") int param2,
							 @RequestParam(required=false) Double param3) {
		System.out.println("Param1: " + param1 + ", Param2: " + param2 + ", Param3: " + param3);
		return "helloWorld";
	}
}
