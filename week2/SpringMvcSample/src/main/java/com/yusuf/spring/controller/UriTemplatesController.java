package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UriTemplatesController {

    /*
     * @RequestMapping annotations can be parametrized by using curly braces. The parameters in defined path
     * can be passed to our method as parameters so that we can use them in our application. In this case
     * @PathVariable annotation must be used so that Spring understand how to inject the value of the parameter
     */
	@RequestMapping(path = "/owners/{ownerId}", method = RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId) {
		System.out.println("OwnerId: " + ownerId);
		return "success";
	}

    /*
     * Spring matches the name of the parameter in @RequestMapping annotation to the name of the parameter
     * in method signature. This way it is possible to define more than one @PathVariable annotation
     */
	@RequestMapping(path = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String findPet(@PathVariable String ownerId, @PathVariable String petId) {
		System.out.println("OwnerId: " + ownerId + ", PetId: " + petId);
		return "success";
	}

    /*
     * It is also possible to write regular expression to map the request to our methods
     */
	@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
	public String handle(@PathVariable String version,  @PathVariable String extension) {
	    System.out.println("version: " + version + ", extension: " + extension);
	    return "success";
	}

}
