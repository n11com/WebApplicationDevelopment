package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoreUriTemplatesController {

    /*
     * You can use "*" to match all request to a path
     */
	@RequestMapping("/web/*")
	public String oneFolder() {
	    System.out.println("In /web/*");
	    return "success";
	}

    /*
     * You can use "**" to match the sub directories as well
     */
	@RequestMapping("/web/**")
	public String allFolders() {
	    System.out.println("In /web/**");
	    return "success";
	}
}
