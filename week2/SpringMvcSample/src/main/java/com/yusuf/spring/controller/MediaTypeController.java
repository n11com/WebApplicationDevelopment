package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yusuf.spring.controller.model.Pet;

@Controller
public class MediaTypeController {

    /*
     * It is possible to define the HTTP method verb that method can process. It is done via
     * @RequestMapping annotation's method parameter.
     *
     * We can also specify the media type that this method can handle by using the consumes parameter.
     * This example will only be triggered if the request is a json request
     */
	@RequestMapping(path = "/pets", method = RequestMethod.POST, consumes = "application/json")
    /*
     * We use @RequestBody annotation to automatically parse the incoming request to a class instance.
     * This instance can be as simple as a String or as complex as custom classes
     */
	public String addPet(@RequestBody Pet pet) {
		System.out.println(pet);
		return "success";
	}

    /*
     * Like the consumes parameter, we can also specify the media type of the return value by using produces
     * parameter
     */
	@RequestMapping(path = "/echoPet", 
					method = RequestMethod.POST, 
					consumes = "application/json",
					produces = "application/json")
    /*
     * @ResponseBody annotation will notify Spring to convert the return value into an appropriate format.
     * Since we set the produces value as application/json, the return value will be converted into a json.
     *
     * Notice that since no view exists in this example (since we used @ResponseBody), we don't return a view name here
     */
	@ResponseBody
	public Pet echoPet(@RequestBody Pet pet) {
		System.out.println(pet);
		return pet;
	}
	
}
