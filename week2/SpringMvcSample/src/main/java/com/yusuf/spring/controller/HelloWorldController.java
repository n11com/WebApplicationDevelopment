package com.yusuf.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * For any class to serve web content, they need to be marked as controllers.
 * Classes that are marked as @Controller will be picked up by Spring and they will be eligible
 * for web requests
 */
@Controller
public class HelloWorldController {

    /*
     * @RequestMapping annotation tell Spring when this method should be triggered by the user.
     * In this particular example, whenever user submits request to /helloWorld by typing it into
     * the address bar of the browser, this method will be triggered.
     */
	@RequestMapping("/helloWorld")
	public String helloWorld() {
        /*
         * Generally controller methods returns the name of the view that should be displayed to the user.
         * Take a look at /src/main/webapp/WEB-INF/example-servlet.xml to understand how Spring maps
         * this return value to a view file. For example since this method returns "helloWorld", then Spring will
         * display /src/main/webapp/WEB-INF/jsp/helloWorld.jsp
         */
		return "helloWorld";
	}
}
