package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UriTemplatesController {

	@RequestMapping(path = "/owners/{ownerId}", method = RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId) {
		System.out.println("OwnerId: " + ownerId);
		return "success";
	}

	@RequestMapping(path = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String findPet(@PathVariable String ownerId, @PathVariable String petId) {
		System.out.println("OwnerId: " + ownerId + ", PetId: " + petId);
		return "success";
	}
	
	@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
	public String handle(@PathVariable String version,  @PathVariable String extension) {
	    System.out.println("version: " + version + ", extension: " + extension);
	    return "success";
	}

}
