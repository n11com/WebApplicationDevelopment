package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yusuf.spring.controller.model.Pet;

@Controller
public class MediaTypeController {
	
	@RequestMapping(path = "/pets", method = RequestMethod.POST, consumes = "application/json")
	public String addPet(@RequestBody Pet pet) {
		System.out.println(pet);
		return "success";
	}
	
	@RequestMapping(path = "/echoPet", 
					method = RequestMethod.POST, 
					consumes = "application/json",
					produces = "application/json")
	@ResponseBody
	public Pet echoPet(@RequestBody Pet pet) {
		System.out.println(pet);
		return pet;
	}
	
}
