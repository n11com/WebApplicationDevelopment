package com.yusuf.spring.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @RequestMapping("/")
    public String home(HttpServletResponse response){
        CookieGenerator cookieGenerator = new CookieGenerator();
        cookieGenerator.setCookieName("myTestCookie");
        cookieGenerator.addCookie(response, "myValue");

        return "cookie";
    }

    @RequestMapping("/read")
    public ModelAndView getCookieValue(@CookieValue("myTestCookie") String cookieValue){
        ModelAndView mav = new ModelAndView("cookie");
        mav.addObject("cookieValue", cookieValue);

        return mav;
    }
}
