package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UriTemplatesController {

	@RequestMapping(path="/owners/{ownerId}", method=RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId) {
		System.out.println("OwnerId: " + ownerId);
	    return "success";
	}
	
}
