package com.yusuf.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yusuf.spring.controller.model.Pet;

@RestController
@RequestMapping("/rest")
public class SampleRestController {
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Pet sayHello(@PathVariable String name) {
		Pet pet = new Pet();
		pet.setName("Hello " + name);
		return pet;
	}
}
