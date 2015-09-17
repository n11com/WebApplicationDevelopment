package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoreUriTemplatesController {
	
	@RequestMapping("/web/*")
	public String oneFolder() {
	    System.out.println("In /web/*");
	    return "success";
	}

	@RequestMapping("/web/**")
	public String allFolders() {
	    System.out.println("In /web/**");
	    return "success";
	}
}
